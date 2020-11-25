import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города на английском:");
            String city = scanner.nextLine();

            setGlobalCity(city);

            System.out.println("Выберите действие:");
            System.out.println("1 - Получить текущую погоду");
            System.out.println("2 - Получить погоду на следующие 5 дней");
            System.out.println("exit/выход - завершить программу");
            String action = scanner.nextLine();

            checkIsExit(action);

            try {
                validateUserInput(action);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(action);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }

    private void checkIsExit(String action) {
        if (action.toLowerCase().equals("выход") || action.toLowerCase().equals("exit")) {
            System.out.println("До свидания!");
            System.exit(0);
        }
    }

    private void validateUserInput(String action) throws IOException {
        if (action == null || action.length() != 1) {
            throw new IOException("Incorrect user input: " + action);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(action);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not number");
        }
    }

    private void notifyController(String action) throws IOException {
        controller.onUserInput(action);
    }
}
