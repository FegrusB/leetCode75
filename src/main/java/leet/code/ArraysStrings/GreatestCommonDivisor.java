package leet.code.ArraysStrings;

import java.util.ArrayList;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB","ABAB"));
    }
    public static String gcdOfStrings(String str1, String str2) {

        String outString = "";

        for (int i = 1; i <= Math.min(str1.length(),str2.length()); i++) {
            ArrayList<String> broken1 = breakString(str1,i);
            ArrayList<String> broken2 = breakString(str2,i);
            if(broken1.isEmpty() || broken2.isEmpty() ){continue;}
            if(broken1.getFirst().equals(broken2.getFirst())){outString = broken1.getFirst();}
        }

        return outString;
    }

    public static ArrayList<String> breakString(String str, int interval){
        ArrayList<String> list = new ArrayList<>();
        if(str.length()%interval != 0){return list;}
        for (int i = 0; i < str.length(); i+=interval) {
            list.add(str.substring(i,i+interval));
        }
        if (!checkEqual(list)){list = new ArrayList<>();}
        return list;
    }

    public static boolean checkEqual(ArrayList<String> checkStrings){
        boolean matching = true;
        for (int i = 0;i<checkStrings.size()-1;i++){
            if (!checkStrings.get(i).equals(checkStrings.get(i + 1))) {
                matching = false;
                break;
            }
        }
        return matching;
    }

}
