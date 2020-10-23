import java.util.Random;

public class Main {
    final static int APP_COUNT = 50;
    final static int FOOD_COUNT = 100;

    public static void main(String[] args) {
        Random r = new Random();
        Cat[] cats = new Cat[5];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Barsik " + (i + 1), r.nextInt(APP_COUNT));
        }

        boolean flagAddFood = false;
        Plate plate = new Plate(FOOD_COUNT);
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            if (!cat.getSatiety()) {
                flagAddFood = true;
            }
            plate.info();
            cat.printSatiety();
        }

        while (flagAddFood) {
            flagAddFood = false;
            System.out.println("Добавить еду в тарелку");
            plate.addFood(r.nextInt(FOOD_COUNT));
            plate.info();

            for (Cat cat : cats) {
                if (!cat.getSatiety()) {
                    cat.eat(plate);
                    if (!cat.getSatiety()) {
                        flagAddFood = true;
                    }
                    plate.info();
                    cat.printSatiety();
                }
            }
        }
    }
}
