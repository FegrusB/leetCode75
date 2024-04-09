package leet.code.ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] out = new int[nums.length];

        out[0] = nums[0];

        for(int i = 1; i < nums.length;i++){
            out[i] = out[i-1] * nums[i];
            nums[i] = suffix(nums,i);
        }

        out[nums.length-1] = out[nums.length-2];

        for(int i = nums.length-2;i > 0; i--){
            out[i] = out[i-1] * nums[i+1];
        }
        out[0] = suffix(nums,0);
        return out;
    }
    public static int suffix(int[] nums, int i){
        if(i + 1 == nums.length){return 0;}
        int out = 1;
        for (int x = i + 1; x < nums.length; x++) {
            out = nums[x] * out;
        }
        return out;
    }
}
