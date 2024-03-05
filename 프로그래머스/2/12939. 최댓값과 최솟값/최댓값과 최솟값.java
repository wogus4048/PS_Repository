import java.util.*;
class Solution {
    public String solution(String s) {
        String[] array = s.split(" ");
        int length = array.length;
        int[] numArray = new int[length];
        for(int i=0;i<length;i++)
        {
            numArray[i] = Integer.parseInt(array[i]);
        }
        
        Arrays.sort(numArray);
        
 
        return numArray[0]+" "+numArray[length-1];
                                
        
        
        
        
    }
}