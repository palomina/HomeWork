import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        task1();

        System.out.println("Задание 2");
        task2();

        System.out.println("Задание 3");
        task3();

        System.out.println("Задание 4");
        task4();

        System.out.println("Задание 5");
        task5();

        System.out.println("Задание 6");
        int[] arr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean res1 = checkBalance(arr1);
        System.out.println(Arrays.toString(arr1) + " - " + res1);

        int[] arr2 = {1, 1, 1, 2, 1};
        boolean res2 = checkBalance(arr2);
        System.out.println(Arrays.toString(arr2) + " - " + res2);

        System.out.println("Задание 7");
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] resShift = shift(arr3, -3);
        System.out.println(Arrays.toString(resShift));

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void task1() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }

        System.out.println(Arrays.toString(arr));
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void task2() {
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 3*i;
        }

        System.out.println(Arrays.toString(arr));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void task4() {
        int[][] arr = new int[8][8];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length-i-1] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void task5() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 0};
        int min, max;

        min = arr[0];
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr) + " min=" + min + " max=" + max);

    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] arr) {
        int sumLeft;
        int sumRight;

        for (int i = 1; i < arr.length-1; i++) {
            sumLeft = 0;
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + arr[j];
            }

            sumRight = 0;
            for (int j = i; j < arr.length; j++) {
                sumRight = sumRight + arr[j];
            }

            if (sumLeft == sumRight) {
                return true;
            }
        }

        return false;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static int[] shift(int[] arr, int n) {
        int x;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                x = arr[arr.length-1];
                for (int j = arr.length-1; j > 0; j--) {
                    arr[j] = arr[j-1];

                }
                arr[0] = x;
            }
        } else {
            for (int i = 0; i < -n; i++) {
                x = arr[0];
                for (int j = 0; j < arr.length-1 ; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = x;
            }
        }

        return arr;
    }

}
