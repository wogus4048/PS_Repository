import java.util.*;
class Solution {
    public int[] solution(long n) {
        
//         char[] array = String.valueOf(n).toCharArray();
//         int length= array.length;
//         int[] answer = new int[length];
        
//         for(int i=0;i<length;i++)
//         {
//             answer[i] = array[length-i-1] -'0';
//         }
        
        
        StringBuilder sb = new StringBuilder();
    
        return sb.append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}