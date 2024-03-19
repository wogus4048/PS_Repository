import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i,j,k;
        int index =0;
        int count =0;
         for(int[] input : commands)
        {
            i = input[0];
            j = input[1];
            k = input[2];
            int[] ar = new int[j-i+1];
            for(int a=i-1;a<j;a++)
            {
                ar[index++] = array[a];
            }
            Arrays.sort(ar);
            answer[count++] = ar[k-1];
            index =0;
            
        }
        
        return answer;
    }
}