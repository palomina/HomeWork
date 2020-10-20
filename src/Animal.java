public class Animal {
    protected String name;

    protected double limitRun;
    protected double limitJump;
    protected double limitSwim;

    public Animal(String name, double limitRun, double limitJump, double limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitJump = limitJump;
        this.limitSwim = limitSwim;
    }

    public boolean run(double distance) {
        return distance <= limitRun;
    }

    public boolean jump(double distance) {
        return distance <= limitJump;
    }

    public boolean swim(double distance) {
        return distance <= limitSwim;
    }

    public String getName() {
        return name;
    };
}
