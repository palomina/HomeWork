public class Track implements Obstacle {
    int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Athlete athlete) {
        boolean result;
        result = athlete.run() >= this.length;
        if (result) {
            System.out.println("Успешно пробежал " + this.length + "м");
        } else {
            System.out.println("Не смог пробежать " + this.length + "м");
        }
        return result;
    }

}
