package practicecodingtest.zbct;

import java.util.*;

class zbct_3_2 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // 여는 괄호일 경우
            if (current == '(' || current == '{' || current == '[' || current == '<') {
                stack.push(current);
            }
            // 닫는 괄호일 경우
            else if (current == ')' || current == '}' || current == ']' || current == '>') {
                if (stack.isEmpty()) {
                    return 0;
                }

                // 괄호 쌍 체크
                char last = stack.pop();
                if ((current == ')' && last != '(') ||
                    (current == '}' && last != '{') ||
                    (current == ']' && last != '[') ||
                    (current == '>' && last != '<')) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}