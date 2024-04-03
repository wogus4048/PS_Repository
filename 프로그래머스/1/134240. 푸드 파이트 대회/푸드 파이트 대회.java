import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<food.length;i++)
        {
            int foodCount = food[i];
            for(int j=0;j<foodCount/2;j++)
            {
                sb.append(i);
            }
        }
        String front = sb.toString();
        String reverse = sb.reverse().toString();
        
        
        return front+"0"+reverse;
    }
}