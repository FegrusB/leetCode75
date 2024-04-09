package leet.code.ArraysStrings;

public class MergeSringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("test","string"));
    }
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < (Math.max(word1.length(), word2.length())) ; i++) {
            if (i < word1.length()){ builder.append(word1.charAt(i));}
            if (i < word2.length()){ builder.append(word2.charAt(i));}
        }
        return builder.toString();
    }
}
