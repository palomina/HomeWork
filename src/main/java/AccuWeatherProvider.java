import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {
    public static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    public static final String HOST = "dataservice.accuweather.com";
    public static final String FORECAST = "forecasts";
    public static final String API_VERSION = "v1";
    public static final String TYPE = "daily";
    public static final String LANGUAGE = "ru-ru";
    public static final String METRIC = "true";
    public static final String HEADER_ACCEPT = "application/json";

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();

        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme("http")
                .host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(TYPE);
        switch (periods) {
            case NOW:
                builder.addPathSegment("1day");
                break;
            case FIVE_DAYS:
                builder.addPathSegment("5day");
                break;
        }
        builder
                .addPathSegment(cityKey)
                .addQueryParameter("language", LANGUAGE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", METRIC);


        HttpUrl url = builder.build();

//        System.out.println(url.toString());

        Request httpRequest = new Request.Builder()
                .addHeader("accept", HEADER_ACCEPT)
                .url(url)
                .build();

        String json = client.newCall(httpRequest).execute().body().string();

        List<WeatherResponse> weatherResponses =
                objectMapper.readValue(objectMapper.readTree(json).at("/DailyForecasts").toString(), new TypeReference<List<WeatherResponse>>() {
                });

        if (weatherResponses.size() > 0) {
            try {
                Db.saveWeather(ApplicationGlobalState.getInstance().getSelectedCity(), weatherResponses);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------------- ПРОГНОЗ ПОГОДЫ ---------------------");
        for (WeatherResponse item : weatherResponses) {
            System.out.println(item);
            System.out.println("----------------------------------------------------");
        }

    }

    private String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

//        System.out.println(url.toString());

        Request httpRequest = new Request.Builder()
                .addHeader("accept", HEADER_ACCEPT)
                .url(url)
                .build();

        Response response = client.newCall(httpRequest).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Город не найден");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }


}
