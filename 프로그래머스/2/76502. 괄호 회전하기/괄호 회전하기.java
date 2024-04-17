
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    static public int solution(String s) {
        int length = s.length();
        int result = 0;

//        Queue<String> q = new LinkedList<>(Arrays.asList(s));
        Queue<String> q = new LinkedList<>();
        Arrays.stream(s.split("")).forEach(q::add);

        for (int i = 0; i < length; i++) {
//            for (String c : q) {
//                System.out.print(c);
//            }
//            System.out.println();
            result += check(q) ? 1:0;
            q.add(q.poll());
        }
        return result;

    }

    static boolean check(Queue<String> q) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String c : q) {
            sb.append(c);
        }

        for (char c : sb.toString().toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else return false;
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else return false;
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else return false;
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int solution = solution("[](){}");
        System.out.println("solution = " + solution);
    }

}