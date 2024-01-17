import java.util.*;
class Solution {
    public String solution(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int count =0;
        for(int i=0;i<length;i++)
        {
            char cChar = s.charAt(i);
            if(cChar==' ')
            {
                count =0;
                sb.append(" ");
                continue;
            }
            if(count %2 ==0)
            {
                cChar = Character.toUpperCase(cChar);
            }
            else{
                cChar = Character.toLowerCase(cChar);
            }
            count++;
            sb.append(cChar);
        }
        return sb.toString();
    }
}