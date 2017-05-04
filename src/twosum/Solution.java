package twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mengli on 4/18/17.
 */
public class Solution {
    public static void main(String[] args) {
        int [] nums = {3, 2, 4};
        int target = 6;
        int [] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] division = new int[nums.length];
        Map<Integer, Integer> divisionMap = new HashMap<>();
        List<Integer> numsList =  Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for(int i=0; i< nums.length; i++) {
            division[i] = target - nums[i];
        }
        for(int i = 0; i < division.length; i++) {
            if(divisionMap.keySet().contains(division[i])) {
                int newValue = divisionMap.get(division[i]) + 1;
                divisionMap.put(division[i], newValue);
            }else {
                divisionMap.put(division[i], 1);
            }
        }
        for(int i=0; i<division.length; i++) {
           if(numsList.contains(division[i])) {
               if(division[i] * 2 != target) {
                   result.add(i);
               }
               else {
                   if(divisionMap.get(division[i]) > 1) {
                       result.add(i);
                   }
               }
           }
           if(result.size() == 2) {
               break;
           }
        }
        int[] index = result.stream().mapToInt(i->i).toArray();
        return index;
    }
}
