import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pLength = p.length();
        long tLength = t.length();
        long pNum = Long.parseLong(p);
        
        for(int i=0;i <= tLength-pLength;i++)
        {
            long cNum = Long.parseLong(t.substring(i,i+(int)pLength));
            // System.out.println(":"+cNum);
            if(cNum <= pNum)
            {
                answer++;
            } 
        }
        
        
        
        
        
        
        
        
        
        return answer;
    }
}