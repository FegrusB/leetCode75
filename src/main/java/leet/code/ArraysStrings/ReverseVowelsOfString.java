package leet.code.ArraysStrings;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {

        String[] split = s.split("");
        Stack<String > stack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            if (checkVowel(split[i])){
                stack.push(split[i]);
                split[i] = "00";
            }
        }
        StringBuilder out = new StringBuilder();
        for (String string : split) {
            if (!Objects.equals(string, "00")) {
                out.append(string);
            } else {
                out.append(stack.pop());
            }
        }
        return out.toString();
    }
    public static boolean checkVowel(String s){
        return switch (s.toLowerCase()) {
            case "a", "e", "i", "o", "u"-> true;
            default -> false;
        };
    }
}
