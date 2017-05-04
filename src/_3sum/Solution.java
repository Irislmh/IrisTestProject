package _3sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mengli on 4/20/17.
 */
public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = IntStream.of(nums).boxed().collect(Collectors.toList());
        for(int i = 0; i < numsList.size(); i++) {
            Collections.sort(numsList);
            numsList.remove(i);
            int [] leftNums = numsList.stream().mapToInt(n -> n).toArray();
            List<List<Integer>> twoSumResult = twoSum(leftNums, 0 - nums[i]);
            if(!twoSumResult.isEmpty()) {
                for(int j = 0; j < twoSumResult.size(); j++) {
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[i]);
                    twoSumResult.get(j).stream().forEach(t -> tempResult.add(t));
                    result.add(tempResult);
                }
            }
        }
        result.stream().forEach(r -> Collections.sort(r));
        List<List<Integer>> deduped = result.stream().distinct().collect(Collectors.toList());

        return deduped;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        threeSum(nums).stream().forEach(list -> list.stream().forEach(i -> System.out.print(i)));
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!result.keySet().contains(target - nums[i])) {
                if(result.keySet().contains(nums[i]) && nums[i] != result.get(nums[i])) {
                    continue;
                }
                result.put(nums[i], nums[i]);
            }
            else {
                result.put(target-nums[i], nums[i]);
            }
        }
        List<Integer> keys = result.keySet().stream().map(k -> k).collect(Collectors.toList());
        for(Integer k : keys) {
            if(result.get(k) == k && result.get(k) + k != target) {
                result.remove(k);
            }
        }
        return result.keySet().stream().map(key -> {
            List<Integer> singleResult = new ArrayList<>();
            singleResult.add(key);
            singleResult.add(result.get(key));
            return singleResult;
        }).collect(Collectors.toList());
    }

}
