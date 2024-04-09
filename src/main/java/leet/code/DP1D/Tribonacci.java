package leet.code.DP1D;

import java.util.ArrayList;
import java.util.Arrays;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
    public static int tribonacci(int n) {
        ArrayList<Integer> list = build();
        return list.get(n);
    }

    public static ArrayList<Integer> build(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 1));
        for (int i = 3; i < 38; i++) {
            int t = list.get(i-3) + list.get(i-2) + list.get(i-1);
            list.add(t);
        }
        return list;
    }
}
