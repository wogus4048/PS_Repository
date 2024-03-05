import java.util.*;
public class Solution {
    static boolean solution(String s) {
        boolean answer = true;
        int count =0;
        
        char[] array = s.toCharArray();
        for(int i=0;i<array.length;i++)
        {
            if(array[i] == ')')
            {
                if(count == 0)
                {
                    answer = false;
                    break;
                }
                else{
                    count--;
                }
            }
            else{
                count++;
            }
        }
        if(count != 0)
        {
            answer =false;
        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));



    }
}