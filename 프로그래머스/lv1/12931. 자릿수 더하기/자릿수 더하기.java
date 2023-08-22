import java.util.*;

public class Solution {
    public int solution(int n) {
        String number = Integer.toString(n);
        int answer =0;
        for(int i=0;i<number.length();i++)
        {
            answer += number.charAt(i) - '0';
        }
        System.out.println(answer+"");
        return answer;
        
    }
}