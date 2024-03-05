import java.util.*;
class Solution {
    public String solution(String s) {
        //받아서 split, 각 배열요소 첫번쨰는 대문자로 바꾸고 나머지는 소문자처리 
        
        String[] input = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        if(input.length == 0)
        {
            return s;
        }
        
        for(int i=0;i<input.length;i++)
        {
            String word = input[i];
            if(word.length() == 0)
            {
                sb.append(" ");
                continue;
            }
            else{
                String tempResult = 
                word.substring(0,1).toUpperCase() + word.substring(1,word.length()).toLowerCase();
            sb.append(tempResult).append(" ");
            }
            
        }
        if(s.charAt(s.length()-1) == ' ')
        {
            return sb.substring(0,sb.length());
        }
        return sb.substring(0,sb.length()-1);
    }
}