import java.util.*;
public class Solution {
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = false;
                    break;
                }
                else{
                    stack.pop();
                }
            }
            else{
                stack.add(s.charAt(i));
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));



    }
}