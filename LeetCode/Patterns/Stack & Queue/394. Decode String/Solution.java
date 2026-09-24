import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int number = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build the number
            if (ch >= '0' && ch <= '9') {
                number = number * 10 + (ch - '0');
            }

            // Save current string and number
            else if (ch == '[') {
                numStack.push(number);
                stringStack.push(current);

                number = 0;
                current = "";
            }

            // Decode the current section
            else if (ch == ']') {

                int repeat = numStack.pop();
                String previous = stringStack.pop();

                String temp = "";

                for (int j = 0; j < repeat; j++) {
                    temp = temp + current;
                }

                current = previous + temp;
            }

            // Normal character
            else {
                current = current + ch;
            }
        }

        return current;
    }
}