package basic001.stream.lambda;

import java.util.function.Supplier;

public class SupplierDemo {

    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        int[] ints = new int[]{12, 5, 6, 21, 3, 56, 87, 13, 1};
        int max1 = getMax(() -> {
            int max = ints[0];
            for (int i = 0; i < ints.length; i++) {
                max = ints[i] > max ? ints[i] : max;
            }
            return max;
        });
        System.out.println(max1);
    }
}
