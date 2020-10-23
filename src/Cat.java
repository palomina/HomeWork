public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " поел " + appetite);
        } else {
            System.out.println(name + " не поел. Хотел скушать " + appetite);
            satiety = false;
        }
    }

    public boolean getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void printSatiety() {
        if (this.getSatiety()) {
            System.out.println(this.getName() + " сытый");
        } else {
            System.out.println(this.getName() + " голодный");
        }
    }
}