package firstuniquechar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengli on 4/24/17.
 */
public class Solution {

    public static void main(String[] args) {
        String s = "loveoxtl";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.lastIndexOf(s.charAt(i)) == i && !list.contains(s.charAt(i))) {
                return i;
            }
            list.add(s.charAt(i));
        }
        return -1;
    }

}
