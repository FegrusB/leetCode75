package leet.code.ArraysStrings;

public class IncreasingTripletSubsequence{


    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {2,1,5,0,4,6}));
    }

    public static boolean increasingTriplet(int[] nums) {

        boolean[][] bigger = new boolean[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]){bigger[i][j] = true;}
            }
        }

        int i = 0;
        boolean possible = false;
        while (!possible && i < nums.length){
            possible = checkPath(bigger,i,0);
            i++;
        }

        return possible;
    }

    public static boolean checkPath(boolean[][] bigger, int x, Integer level){

        boolean possible = false;

        level++;
        if (level == 3){ return true;}

        int i = 0;
        while (!possible && i < bigger.length){
            if (bigger[x][i]){possible = checkPath(bigger,i,level);}
            i++;
        }
        return possible;
    }


}
