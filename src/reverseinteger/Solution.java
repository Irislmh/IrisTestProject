package reverseinteger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mengli on 4/19/17.
 */
public class Solution {

    public static void main(String[] args) {
        int x = 0;
        System.out.println(reverse(x));

    }

    public static int reverse(int x) {
        boolean negative = false;
        String s = String.valueOf(x);
        List<Character> list = s.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());
        if(list.get(0) == '-') {
            negative = true;
            list.remove(0);
        }
        Collections.reverse(list);
        if(list.get(list.size() - 1) == '0' && list.size() > 1) {
            list.remove(list.size() - 1);
        }
        String str = list.stream().map(e->e.toString()).reduce((acc, e) -> acc  + e).get();
        if(negative) {
            str = "-" + str;
        }

        int result = 0;
        try {
            result = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            System.out.println("Out of Integer range");
        }
        return result;
    }
}
