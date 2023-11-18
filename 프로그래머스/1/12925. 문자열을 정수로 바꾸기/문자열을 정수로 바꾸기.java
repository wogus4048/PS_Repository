import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char t = s.charAt(0);
        
        if(t =='+' || t == '-')
        {
            s = s.substring(1,s.length());
            answer = Integer.parseInt(s);
            
            if( t == '-')
            {
                answer *= -1;
            }
        }
        else
        {
            answer = Integer.parseInt(s);
        }
        
        
        return answer;
    }
}