public class Wall implements Obstacle{
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Athlete athlete) {
        boolean result;
        result = athlete.jump() >= this.height;
        if (result) {
            System.out.println("Успешно перепрыгнул " + this.height + "м");
        } else {
            System.out.println("Не смог перепрыгнуть " + this.height + "м");
        }
        return result;
    }
}
