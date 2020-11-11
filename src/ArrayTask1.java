import java.util.Arrays;

public class ArrayTask1<T> {
    private T[] nums;
    private T temp;

    public ArrayTask1(T... nums) {
        this.nums = nums;
    }

    public void change(int i, int j) throws ArrayIndexOutOfBoundsException {
        if (i < 0 ||
            i >= nums.length ||
            j < 0 ||
            j >= nums.length
        ) {
            throw new ArrayIndexOutOfBoundsException("Заданные индексы не входят в размерность массива");
        }

        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void print() {
        System.out.println(Arrays.toString(nums));
    }
}
