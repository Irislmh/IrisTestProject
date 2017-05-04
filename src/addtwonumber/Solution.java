package addtwonumber;

/**
 * Created by mengli on 4/25/17.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(getSum(184, 2948));
        System.out.println(getSum(302, 394));

        System.out.println(getSum(1, 5));

    }

    public static int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
}
