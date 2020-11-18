public class Main {
    public static void main(String[] args) {
        String[] header = new String[]{"Value1", "Value2", "Value3"};
        int[][] data = new int[][]{{100, 200, 300}, {250, 350, 450}};


        AppData appData = new AppData("demo.csv", header, data);
        System.out.println("Save");
        appData.save();
        System.out.println("Load");
        appData.load();
        appData.print();
    }
}
