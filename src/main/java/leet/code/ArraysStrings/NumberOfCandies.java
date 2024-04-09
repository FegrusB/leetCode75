package leet.code.ArraysStrings;

import java.util.Arrays;
import java.util.List;

public class NumberOfCandies {

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3},3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        //if(Arrays.stream(candies).max().isPresent()){max = Arrays.stream(candies).max().getAsInt();}
        for (int i: candies){if (i > max){max = i;}}
        int needed = max - extraCandies;
        Boolean[] out = new Boolean[candies.length];
        Arrays.fill(out,false);
        for (int i = 0; i < candies.length; i++) {if (candies[i] >= needed){out[i] = true;}}
        return Arrays.asList(out);
    }
}
