package leet.code.ArraysStrings;

public class IncreasingTripletSubsequence{


    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {5,4,3,2,1}));
    }

    public static boolean increasingTriplet(int[] nums) {

        int biggest = nums[0];
        for (int i: nums){if(biggest < i){biggest = i;}}

        int i = 0;
        boolean possible = false;
        while (!possible && i < nums.length){
            possible = checkPath(nums,i,0);
            i++;
        }
        return possible;
    }

    public static boolean checkPath(int[] nums, int x, Integer level, int biggest){

        boolean possible = false;


        level++;
        if (level == 3){ return true;}

        int i = x + 1;
        while (!possible && i < nums.length){
            if (nums[x] < nums[i]){
                possible = checkPath(nums,i,level);
            }
            i++;
        }
        return possible;
    }


}
