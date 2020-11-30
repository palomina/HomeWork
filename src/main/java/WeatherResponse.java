import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class DayWeather {
        public String IconPhrase;

        public String getIconPhrase() {
            return IconPhrase;
        }

        @Override
        public String toString() {
            return IconPhrase;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Temperature {

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Minimum {
            public String Value;
            public String Unit;

            @Override
            public String toString() {
                return Value + Unit;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Maximum {
            public String Value;
            public String Unit;

            @Override
            public String toString() {
                return Value + Unit;
            }
        }

        Minimum minimum = new Minimum();
        Maximum maximum = new Maximum();

        @JsonSetter("Minimum")
        public void setMinimum(Minimum minimum) {
            this.minimum = minimum;
        }

        @JsonGetter("Minimum")
        public Minimum getMinimum() {
            return minimum;
        }

        @JsonSetter("Maximum")
        public void setMaximum(Maximum maximum) {
            this.maximum = maximum;
        }

        @JsonGetter("Maximum")
        public Maximum getMaximum() {
            return maximum;
        }

        @Override
        public String toString() {
            return "от " + minimum + " до " + maximum;
        }

    }


    String datetime;

    DayWeather weather = new DayWeather();
    Temperature temperature;

    @JsonSetter("Date")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonGetter("Date")
    public String getDatetime() {
        return datetime;
    }

    @JsonSetter("Day")
    public void setWeather(DayWeather weather) {
        this.weather = weather;
    }

    @JsonGetter("Day")
    public DayWeather getWeather() {
        return weather;
    }

    @JsonSetter("Temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonGetter("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Дата: " + datetime + "\n"
                + "Прогноз: " + weather + "\n"
                + "Температура: " + temperature;
    }

    public WeatherResponse() {
    }

}
