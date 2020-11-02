public class Main {

    public static void main(String[] args) {
        Athlete[] athletes = {
            new Human("Вася", 100, 3),
            new Human("Петя", 300, 1),
            new Human("Коля", 500, 10),
            new Cat("Матроскин", 500, 10),
            new Robot("Вертер", 100, 1),
            new Robot("R2D2", 50000, 1000000),
            new Cat("Мурзик", 250, 7),
        };

        Obstacle[] obstacles = {
          new Track(100),
          new Wall(1),
          new Track(300),
          new Wall(1),
          new Wall(2),
          new Wall(3)
        };

        boolean isFinished;
        for (Athlete athlet: athletes) {
            System.out.println("\nНа дистанцию выходит - " + athlet.getName());
            isFinished = true;
            for (Obstacle obstacle: obstacles) {
                if (!obstacle.overcome(athlet)) {
                    System.out.println(athlet.getName() + " выбывает");
                    isFinished = false;
                    break;
                }
            }
            if (isFinished) {
                System.out.println(athlet.getName() + " прошел дистанцию!!!");
            }
        }
    }
}
