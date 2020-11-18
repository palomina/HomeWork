import java.io.*;
import java.util.Arrays;

public class AppData {
    private File file;

    private String delimiter = ";";

    private String[] header;
    private int[][] data;

    public AppData(String filename, String[] header, int[][] data) {
        this.file = new File(filename);
        this.header = header;
        this.data = data;
    }

    public AppData(File file, String[] header, int[][] data) {
        this.file = file;
        this.header = header;
        this.data = data;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            str = reader.readLine();
            header = str.split(delimiter);

            int rows = 0;
            while ((str = reader.readLine()) != null) {
                int cols = 0;
                data[rows] = new int[str.split(delimiter).length];
                for (String value : str.split(delimiter)) {
                    data[rows][cols] = Integer.parseInt(value);
                    cols++;
                }
                rows++;
                if (rows >= data.length) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            System.out.println(String.join(delimiter, header));
            writer.write(String.join(delimiter, header));
            writer.newLine();
            for (int[] row : data) {
                String strArray[] = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    strArray[i] = String.valueOf(row[i]);
                }
//2-й вариант превращения массива чисел в строковый массив
//https://www.techiedelight.com/convert-int-array-string-array-java/
//                String strArray[] = Arrays.stream(row)
//                        .mapToObj(String::valueOf)
//                        .toArray(String[]::new);

                System.out.println(String.join(delimiter, strArray));
                writer.write(String.join(delimiter, strArray));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(String.join(delimiter, header));
        for (int[] row : data) {
            String strArray[] = new String[row.length];
            for (int i = 0; i < row.length; i++) {
                strArray[i] = String.valueOf(row[i]);
            }
            System.out.println(String.join(delimiter, strArray));
        }
    }

}
