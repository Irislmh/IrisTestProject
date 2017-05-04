package intersectionoftwoarraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mengli on 4/26/17.
 */
public class Solution {

  public static void main(String[] args) {
    int[] nums1 = {-1,1,2,3};
    int[] nums2 = {1,-2,-2147483648};
    int[] result = intersect(nums1, nums2);
    for (Integer i : result) {
      System.out.println(i);
    }
  }

  public static int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> numsList1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
    List<Integer> numsList2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
    List<Integer> result = new ArrayList<>();

    Collections.sort(numsList1);
    Collections.sort(numsList2);

    int i = 0;
    int j = 0;
    while(i < numsList1.size() && j < numsList2.size()) {
      if (numsList1.get(i).intValue() < numsList2.get(j).intValue()) {
        i++;
      }
      else if (numsList1.get(i).intValue() == numsList2.get(j).intValue()) {
        result.add(numsList1.get(i));
        i++;
        j++;
      }
     else if (numsList1.get(i).intValue() > numsList2.get(j).intValue()) {
        j++;
      }
    }
    return result.stream().mapToInt(n -> n).toArray();
  }

}
