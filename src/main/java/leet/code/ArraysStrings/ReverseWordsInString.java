package leet.code.ArraysStrings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {

        Stack<String> stack = new Stack<>();
        LinkedList<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' '){queue.add(s.charAt(i));}
            else if (!queue.isEmpty()){
                StringBuilder word = new StringBuilder();
                while (!queue.isEmpty()){word.append(queue.poll());}
                word.append(' ');
                stack.push(word.toString());
            }
        }
        if (!queue.isEmpty()){
            StringBuilder word = new StringBuilder();
            while (!queue.isEmpty()){word.append(queue.poll());}
            stack.push(word.toString());
        }

        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()){out.append(stack.pop());}
        out.deleteCharAt(out.length()-1);
        return out.toString();
    }
}
