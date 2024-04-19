package leet.code.ArraysStrings;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','a','b','b','a','a'}));
    }

    public static int compress(char[] chars) {

        char lastChar = chars[0];
        AtomicInteger lastAdrr = new AtomicInteger( 0);
        int count = 0;
        int i = 0;

        while (i < chars.length) {
            if (lastChar == chars[i]) {
                count++;
                i++;
            } else if(count == 1){
                chars[lastAdrr.get()] = lastChar;
                lastAdrr.incrementAndGet();
                lastChar = chars[i];
                count = 0;
            } else {
                chars = writeCount(chars,lastChar,lastAdrr,count);
                lastChar = chars[i];
                count = 0;
            }
        }

        if (count > 1){
            chars = writeCount(chars,lastChar,lastAdrr,count);
        } else if (count == 1){
            chars[lastAdrr.get()] = lastChar;
            lastAdrr.incrementAndGet();
        }
        return lastAdrr.get();
    }

    public static char[] writeCount(char[] chars,char lastChar,AtomicInteger lastAdrr,int count) {
        chars[lastAdrr.get()] = lastChar;
        lastAdrr.incrementAndGet();
        if (lastAdrr.get() < chars.length) {
            Stack<Character> stack = buildStack(count);
            while (!stack.isEmpty()) {
                chars[lastAdrr.get()] = stack.pop();
                lastAdrr.incrementAndGet();
            }
        }
        return chars;
    }
    public static Stack<Character> buildStack(int count){
        Stack<Character> stack = new Stack<>();
        while (count >= 1) {
            stack.push((char) ((count % 10) + 48));
            count = count / 10;
        }
        return stack;
    }

}


