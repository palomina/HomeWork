
import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static int X_SIZE = 5;
    public static int Y_SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static char[][] map = new char[Y_SIZE][X_SIZE];

    public static char PLAYER1_DOT = 'X';
    public static char PLAYER2_DOT = 'O';
    public static char EMPTY_DOT = ' ';

    public static int last_x = 0;
    public static int last_y = 0;

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args){
        initMap();
        printMap();

        while (true) {
            player1Step();
            printMap();
            if (checkWin(PLAYER1_DOT)) {
                System.out.println("Победил Игрок 1");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            blockStep();
//            player2Step();
            printMap();
            if (checkWin(PLAYER2_DOT)) {
                System.out.println("Победил Игрок 2");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");


    }

    private static void initMap() {
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    private static void initMap2() {
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }

        map[2][0] = PLAYER1_DOT;
        map[1][1] = PLAYER1_DOT;
        map[0][2] = PLAYER1_DOT;
    }

    private static void printMap() {
        for (int i = 0; i <= Y_SIZE; i++) {
            if (i != 0) {
                System.out.print(i + " ");
            }else {
                System.out.print("  ");
            }
        }
        System.out.println();
        for (int i = 0; i < Y_SIZE; i++) {


            System.out.print((i + 1) );
            System.out.print("|");
            for (int j = 0; j < X_SIZE; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }

    }

    private static void setSymbol(int y, int x, char symbol) {
        map[y][x] = symbol;
    }

    private static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > X_SIZE - 1 || y > Y_SIZE - 1) {
            return false;
        }
        return map[y][x] == EMPTY_DOT;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private static void player1Step() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X и Y (" + X_SIZE + " " + Y_SIZE +")" );
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y,x));
        System.out.println("Игрок 1 походил в точку " + (x + 1) + " " + (y + 1));

        last_x = x;
        last_y = y;

        setSymbol(y, x, PLAYER1_DOT);
    }

    private static void player2Step() {
        int x;
        int y;
        do {
            x = rand.nextInt(X_SIZE);
            y = rand.nextInt(Y_SIZE);
        } while (!isCellValid(y,x));
        System.out.println("Игрок 2 походил в точку " + (x + 1) + " " + (y + 1));
        setSymbol(y, x, PLAYER2_DOT);
    }

    private static boolean checkWinHorizontal(char symbol) {
        for (int i = 0; i < Y_SIZE; i++) {
            for (int j = 0; j <= X_SIZE - DOTS_TO_WIN; j++) {
                if (map[i][j] == symbol) {
                    int dots = 1;
                    for (int k = 1; k < DOTS_TO_WIN ; k++) {
                        if (map[i][j+k] == symbol) {
                            dots++;
                        } else {
                            break;
                        }
                    }
                    if (dots == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkWinVertical(char symbol) {
        for (int i = 0; i <= Y_SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                if (map[i][j] == symbol) {
                    int dots = 1;
                    for (int k = 1; k < DOTS_TO_WIN ; k++) {
                        if (map[i+k][j] == symbol) {
                            dots++;
                        } else {
                            break;
                        }
                    }
                    if (dots == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean checkWinDiagonal(char symb) {
        for (int i = 0; i <= Y_SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= X_SIZE - DOTS_TO_WIN; j++) {
                if (map[i][j] == symb) {
                    int dots = 1;
                    for (int k = 1; k < DOTS_TO_WIN ; k++) {
                        if (map[i+k][j+k] == symb) {
                            dots++;
                        } else {
                            break;
                        }
                    }
                    if (dots == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal2(char symb) {
        for (int i = 0; i <= Y_SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j < X_SIZE; j++) {
                if (map[i][j] == symb) {
                    int dots = 1;
                    for (int k = 1; k < DOTS_TO_WIN && j-k >=0 ; k++) {
                        if (map[i+k][j-k] == symb) {
                            dots++;
                        } else {
                            break;
                        }
                    }
                    if (dots == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        if (checkWinHorizontal(symbol) || checkWinVertical(symbol) || checkWinDiagonal(symbol) || checkWinDiagonal2(symbol)) {
            return true;
        }
        return false;
    }


    private static void blockStep() {
        int next_x=-1;
        int next_y=1;

        int [][] t = {
                {-1, -1, 1,1},
                {0, -1, 0, 1},
                {1, -1, -1, 1},
                {1, 0, -1, 0},
                {1, 1, -1, -1},
                {0, 1, 0, -1},
                {-1, 1, 1, -1},
                {-1, 0, 1, 0},
                {0, 0, 1,1},
                {0, 0, 0, 1},
                {0, 0, -1, 1},
                {0, 0, -1, 0},
                {0, 0, -1, -1},
                {0, 0, 0, -1},
                {0, 0, 1, -1},
                {0, 0, 1, 0},
        };

        for (int i = 0; i < t.length; i++) {
            if (((last_y+t[i][1]>=0) && (last_x+t[i][0]>=0) && (last_y+t[i][1]<Y_SIZE) && (last_x+t[i][0]<X_SIZE)) && map[last_y+t[i][1]][last_x+t[i][0]]==PLAYER1_DOT) {
                if (((last_y+t[i][3]>=0) && (last_x+t[i][2]>=0) && (last_y+t[i][3]<Y_SIZE) && (last_x+t[i][2]<X_SIZE)) && map[last_y+t[i][3]][last_x+t[i][2]]==EMPTY_DOT) {
                    next_y = last_y+t[i][3];
                    next_x = last_x+t[i][2];
                    break;
                }
            }
        }

        if (next_x==-1) {
            player2Step();
        } else {
            setSymbol(next_y, next_x, PLAYER2_DOT);
        }

    }
}
