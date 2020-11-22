import com.google.gson.*;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Main {
    // api key eVrMSSWUZNkvJQG02PcVyCvmSem4GJFc
    // http://dataservice.accuweather.com/forecasts/v1/daily/5day/
    // https://www.accuweather.com/en/ru/saint-petersburg/295212/weather-forecast/295212 - Санкт-Петербург

    public static final String API_KEY = "eVrMSSWUZNkvJQG02PcVyCvmSem4GJFc";
    public static final String HOST = "dataservice.accuweather.com";
    public static final String FORECAST = "forecasts";
    public static final String API_VERSION = "v1";
    public static final String TYPE = "daily";
    public static final String PERIOD = "5day";
    public static final String CITY_ID = "295212";
    public static final String LANGUAGE = "ru-ru";
    public static final String METRIC = "true";
    public static final String HEADER_ACCEPT = "application/json";


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(TYPE)
                .addPathSegment(PERIOD)
                .addPathSegment(CITY_ID)
                .addQueryParameter("language", LANGUAGE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", METRIC)
                .build();

        System.out.println(url.toString());

        Request httpRequest = new Request.Builder()
                .addHeader("accept", HEADER_ACCEPT)
                .url(url)
                .build();

        String json = client.newCall(httpRequest).execute().body().string();

        System.out.println(json);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(json);
        String prettyJsonString = gson.toJson(je);

        System.out.println(prettyJsonString);

    }
}
