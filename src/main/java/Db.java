import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
    private static Connection connection = null;

    private Db() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");

                connection = DriverManager.getConnection("jdbc:sqlite:weather.db");

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM city_weather");

                System.out.println(rs);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveWeather(String city, List<WeatherResponse> list) throws SQLException {

        try (PreparedStatement statement = Db.getConnection().prepareStatement("INSERT INTO `city_weather` (`city`, `localDate`, `weatherText`, `temperature_min`, `temperature_max`, `unit`) VALUES (?, ?, ?, ?, ?, ?)")) {
            for (WeatherResponse weatherData : list) {
                statement.setString(1, city);
                statement.setString(2, weatherData.getDatetime());
                statement.setString(3, weatherData.getWeather().getIconPhrase());
                statement.setString(4, weatherData.getTemperature().getMinimum().Value);
                statement.setString(5, weatherData.getTemperature().getMaximum().Value);
                statement.setString(6, weatherData.getTemperature().getMaximum().Unit);
                statement.addBatch();
            }
            int[] result = statement.executeBatch();
        } catch (Exception e) {
        }
    }

    public static void readWeather() {
        try {
            String city = ApplicationGlobalState.getInstance().getSelectedCity();
            PreparedStatement stmt = Db.getConnection().prepareStatement("SELECT * FROM city_weather where city = ?");
            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Вывод данных из БД: ");
            while (rs.next()) {
                System.out.println("Погода в " + rs.getString(2) + " на " + rs.getString(3) + ": " + rs.getString(4) + ", температура от " + rs.getString(5) + " до " + rs.getString(6) + rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}