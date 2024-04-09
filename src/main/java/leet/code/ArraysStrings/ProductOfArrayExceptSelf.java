package leet.code.ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int i = 0;

        HashMap<Integer,Integer> productMap = new HashMap<>();

        while (i< nums.length && productMap.size() < 61){
            if (!productMap.containsKey(nums[i])){
                productMap.put(nums[i],calc(nums,i));
            }
            i++;
        }

        for (int j = 0; j < nums.length; j++) {nums[j] = productMap.get(nums[j]);}

        return nums;
    }
    public static int calc(int[] nums, int i){
        int out = 1;
        for (int j = 0; j < nums.length; j++) {if (j != i){ out = out * nums[j];}}
        return out;
    }
}
