package palindromenumber;

/**
 * Created by mengli on 4/19/17.
 */
public class Solution {

    public static void main(String[] args) {
        int x = -12321;
        System.out.println(String.valueOf(isPalindrome(x)));

        x = 123;
        System.out.println(String.valueOf(isPalindrome(x)));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char [] c = s.toCharArray();
        for(int i = 0; i < c.length/2; i++) {
            if(c[i] != c[c.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
