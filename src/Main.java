import java.util.Arrays;

public class Main {
    private static int ROWS = 5;
    private static int COLUMNS = 5;

    public static void main(String[] args) {
        int increment = 1;
        int[][] arr = new int[ROWS][COLUMNS];


        int d = Math.min(ROWS, COLUMNS);
        for (int r = 0; r < Math.ceil((double)d / 2) ; r++) {
            arr = fillCircle(arr, increment, r, ROWS - 2*r, COLUMNS -2*r);
            increment += 2*((ROWS - 2*r) + (COLUMNS - 2*r) - 2);
        }

        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] fillCircle(int[][] a, int inc, int d, int lx, int ly) {
        for (int i = 0; i < ly; i++) {
            if (a[d][d+i] == 0) {
                a[d][d + i] = inc++;
            }
        }
        for (int i = 1; i < lx; i++) {
            if (a[d+i][d + ly -1] == 0) {
                a[d + i][d + ly - 1] = inc++;
            }
        }
        for (int i = ly-2; i >= 0 ; i--) {
            if (a[d+lx - 1][d+i] == 0) {
                a[d + lx - 1][d + i] = inc++;
            }
        }
        for (int i = lx-2; i >= 1 ; i--) {
            if (a[d+i][d] == 0) {
                a[d + i][d] = inc++;
            }
        }

        return a;
    }


}
