public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 0.5, 10);
    }

    public Dog(String name, double limitRun, double limitJump, double limitSwim) {
        super(name, limitRun, limitJump, limitSwim);
    }

    @Override
    public String getName() {
        return "Собака по имени " + name + " ";
    }

}
