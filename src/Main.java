public class Main {
    public static void main(String[] args) {
        double distanceRun = 150;
        double distanceJump = 2;
        double distanceSwim = 7;

        Animal[] animals = {
                new Cat("Мурзик", 100, 1),
                new Cat("Васька"),
                new Cat("Маркиз", 500, 5),
                new Dog("Бобик", 250, 2, 3),
                new Dog("Барбос"),
                new Dog("Пират", 540, 1, 15)
        };
        for (Animal animal : animals) {
            if (animal.run(distanceRun)) {
                System.out.println(animal.getName() + " - пробежал дистанцию " + distanceRun + " м.");
            } else {
                System.out.println(animal.getName() + " -  не пробежал дистанцию " + distanceRun + " м.");
            }

            if (animal.jump(distanceJump)) {
                System.out.println(animal.getName() + " - прыгнул на высоту " + distanceJump + " м.");
            } else {
                System.out.println(animal.getName() + " -  не прыгнул на высоту " + distanceJump + " м.");
            }

            if (animal.swim(distanceSwim)) {
                System.out.println(animal.getName() + " - проплыл дистанцию " + distanceSwim + " м.");
            } else {
                System.out.println(animal.getName() + " -  не проплыл дистанцию " + distanceSwim + " м.");
            }
        }
    }
}
