import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int length = A.length;
        Arrays.sort(A); // 오름차순
        
        Integer[] array = new Integer[length];
        
        for(int i=0;i<length;i++)
        {
            array[i] = B[i];
        }
        
        Arrays.sort(array, Comparator.reverseOrder());
        
        
        for(int i=0;i<length;i++)
        {
            answer += A[i]*array[i];
        }
        

        

        return answer;
    }
}