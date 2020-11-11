import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<T> ();
    }

    public void add(T fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        return !fruits.isEmpty() ? fruits.get(0).getWeight() * fruits.size() : 0;
    }

    public boolean compare(Box<?> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void shift(Box<T> anotherBox) {
        for (int i = this.fruits.size()-1; i >= 0 ; i--) {
            anotherBox.add(this.fruits.get(i));
            this.fruits.remove(i);
        }
    }
}
