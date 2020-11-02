public class Human implements Athlete{
    String name;
    int distance;
    int jumpHeight;

    Human(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.jumpHeight = height;
    }

    @Override
    public int jump() {
        System.out.println("Человек " + this.name + " прыгает");
        return jumpHeight;
    }

    @Override
    public int run() {
        System.out.println("Человек " + this.name + " бежит");
        return distance;
    }

    @Override
    public String getName() {
        return name;
    }
}
