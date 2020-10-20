public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 2, 0);
    }

    public Cat(String name, double limitRun, double limitJump) {
        super(name, limitRun, limitJump, 0);
    }

    @Override
    public boolean swim(double distance) {
        return false;
    }

    @Override
    public String getName() {
        return "Кот по имени " + name + " ";
    }
}
