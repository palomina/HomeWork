import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        task1(sc);
        task2(sc);
        task3();
        sc.close();
    }

    //1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
    // это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
    // (1 – повторить, 0 – нет).
    private static void task1(Scanner sc) {
        Random rand = new Random();
        int n;
        int min = 0;
        int max = 10;
        int x = rand.nextInt(max);
        boolean isWin = false;
        int newGame = 0;


        do {
            newGame = 0;
            isWin = false;
            for (int i = 0; i < 3; i++) {
                do {
                    System.out.println("Введите число от 0 до 9");
                    n = sc.nextInt();
                } while (n < min || n > max);

                if (n == x) {
                    isWin = true;
                    break;
                } else {
                    System.out.println("Число " + n + ((n > x) ? " больше" : " меньше") + " загаданного.");
                }
            }

            if (isWin) {
                System.out.println("Поздравляем! Вы угадали число.");
            } else {
                System.out.println("Число " + x + " не угадано.");
            }

            do {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                newGame = sc.nextInt();
            } while (newGame != 0 && newGame != 1);
        } while (newGame == 1);

        System.out.println("Пока!");
    }


    //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
    // "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
    // "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
    // компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    private static void task2(Scanner sc) {
        Random rand = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[rand.nextInt(words.length)];
        String tryWord;
        String maskedWord;
        String mask = "#";
        int maskLength = 15;

        boolean isWin = false;

        while (!isWin) {
            System.out.println("Введите слово");
            tryWord = sc.next();

            if (!tryWord.equals(word)) {
                maskedWord = "";
                for (int i = 0; i < ((tryWord.length() > word.length()) ? word.length() : tryWord.length()); i++) {
                    maskedWord = maskedWord + ((tryWord.charAt(i) == word.charAt(i)) ? word.charAt(i) : mask);
                }
                for (int i = maskedWord.length(); i < maskLength; i++) {
                    maskedWord = maskedWord + mask;
                }
                System.out.println("Угаданные буквы: " + maskedWord);
            } else {
                isWin = true;
                System.out.println("Поздравляем! Вы угадали слово.");
            }
        }
        System.out.println("Пока!");
    }

    private static void task3() {
        String s = "Предложение    один    Теперь     предложение   два  Предложение   три   ";

        System.out.println(s);

        String s1 = s.trim().replaceAll(" +", " ");

        StringBuilder s2 = new StringBuilder(s1);

        for (int i = 1; i < s2.length(); i++) {
            if (s2.charAt(i) >= 'А' && s2.charAt(i) <= 'Я') {
                s2.setCharAt(i - 1, '.');
                s2.insert(i, ' ');
                i++;
            }
        }

        if (s2.charAt(s2.length() - 1) != '.') {
            s2.append('.');
        }

        System.out.println(s2);
    }

}
