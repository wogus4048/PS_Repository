import java.util.Stack;

class Solution
{
    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (Character character : s.toCharArray()) {
            stack.add(character);
        }

        while (!stack.isEmpty()) {
            char current = stack.pop();
            if (!stack.isEmpty() && current == stack.peek()) {
                stack.pop();
            }
            else if(!stack2.isEmpty() && stack2.peek() == current){
                stack2.pop();
            }
            else{
                stack2.add(current);
            }

        }
        if(!stack2.isEmpty()) return 0;


        return 1;

    }


    public static void main(String[] args) {
        System.out.println(solution("baabaa"));

    }
}