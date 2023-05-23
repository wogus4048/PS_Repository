import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        for(String temp : s.split(" "))
        {
            if(temp.length() == 0)
            {
                answer+=" ";
                continue;
            }
            int asc = (int)temp.charAt(0);
            int sub = 0;
            if(asc >= 97 && asc <= 122 )
            {
                sub = 32;
            }
            char t = (char)(asc -sub);
            // System.out.println(t+" !!!!");
            answer += t;
            
            for(int i=1;i<temp.length();i++)
            {
                int addd =0;
                if((int)temp.charAt(i) >= 65 && (int)temp.charAt(i) <= 90 )
                {
                    addd = 32;
                }
                char tt = (char)(temp.charAt(i) + addd);
                answer += tt;
            }
            answer+=" ";
        }
        answer = answer.substring(0,answer.length()-1);
        if( Character.toString(s.charAt(s.length()-1)).equals(" "))
        {
            answer+= " ";
        }
        
        return answer;
    }
}