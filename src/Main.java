public class Main {

    public static void main(String[] args) {
        String arr4x4[][] = {
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };
        String arr5x5[][] = {
                {"1","1","1","1","1"},
                {"1","1","1","1","1"},
                {"1","1","1","1","1"},
                {"1","1","1","1","1"},
                {"1","1","1","1","1"}
        };

        String arr4x4Bad[][] = {
                {"1","1","1","1"},
                {"1","1","1","1"},
                {"1","1","1","A"},
                {"1","1","1","1"}
        };

        try {
            System.out.println("Сумма 4x4 = " + sumArray(arr4x4));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println("Сумма 5x5 = " + sumArray(arr5x5));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            System.out.println("Сумма 4x4 = " + sumArray(arr4x4Bad));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

    }


    public static int sumArray(String arr[][]) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;

        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int value = Integer.parseInt(arr[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "," + j +"] не число");
                }
            }
        }

        return sum;
    }
}
