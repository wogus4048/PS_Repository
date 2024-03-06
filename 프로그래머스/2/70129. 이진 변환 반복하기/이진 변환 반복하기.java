import java.util.*;
class Solution {
    static int zero =0;
    static int count =0;
    public int[] solution(String s) {
        String input = s;
        
        while(true)
        {
            int resultLength = solve(input);
            count++;
            if(resultLength == 1)
            {
                break;
            }
            else{
                input = Integer.toString(resultLength,2);
            }
        
        }

        
        return new int[]{count,zero};
    }
    
    public int solve(String s)
    {
        char[] array = s.toCharArray();
        int length =0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i] == '1')
            {
                length++;
            }
            else{
                zero++;
            }
        }
        return length;
    }
}