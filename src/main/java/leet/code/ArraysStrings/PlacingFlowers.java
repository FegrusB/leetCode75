package leet.code.ArraysStrings;

import java.util.ArrayList;

public class PlacingFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int possibleCount = 0;
        boolean finished = false;
        int i = 0;

        while (possibleCount < n && i<flowerbed.length) {
            ArrayList<Integer> checkArea = getCheckArea(i,flowerbed.length);
            boolean placeable = true;
            for(int x:checkArea){
                if (flowerbed[i + x] == 1) {
                    placeable = false;
                    break;
                }}
            if (placeable){
                possibleCount++;
                flowerbed[i] = 1;
            }
            i++;
        }
        return possibleCount >= n;
    }
    public static ArrayList<Integer> getCheckArea(int index, int arraySize){

        ArrayList<Integer> checkArea = new ArrayList<>();

        if (!(index == 0)){ checkArea.add(-1);}
        checkArea.add(0);
        if (!(index==arraySize-1)){checkArea.add(1);}

        return checkArea;
    }
}
