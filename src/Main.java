public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("Задание 1.");

        ArrayTask1<Integer> arr = new ArrayTask1<>(1, 2, 3, 4, 5, 6, 7);
        arr.print();
        try {
            arr.change(2, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        arr.print();
    }

    public static void task2() {
        System.out.println("\nЗадание 2.");

        Box<Orange> boxOrange = new Box<>();
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());
        boxOrange.add(new Orange());

        Box<Orange> boxOrange2 = new Box<>();
        boxOrange2.add(new Orange());
        boxOrange2.add(new Orange());

        Box<Apple> boxApple = new Box<>();
        boxApple.add(new Apple());
        boxApple.add(new Apple());
        boxApple.add(new Apple());


        System.out.println("Коробка апельсинов 1 = " + boxOrange.getWeight());
        System.out.println("Коробка апельсинов 2 = " + boxOrange2.getWeight());
        System.out.println("Коробка яблок = " + boxApple.getWeight());

        System.out.println("Коробка апельсинов 1 и Коробка апельсинов 2 = " + boxOrange.compare(boxOrange2));
        System.out.println("Коробка апельсинов 1 и Коробка яблок = " + boxOrange.compare(boxApple));
        System.out.println("Коробка апельсинов 2 и Коробка яблок = " + boxOrange2.compare(boxApple));

        System.out.println("Коробка апельсинов 1 -> Коробка апельсинов 2 ");
        boxOrange.shift(boxOrange2);
        System.out.println("Коробка апельсинов 1 = " + boxOrange.getWeight());
        System.out.println("Коробка апельсинов 2 = " + boxOrange2.getWeight());
    }
}
