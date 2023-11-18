import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] check = new boolean[10];
        
        for(int num : numbers)
        {
            check[num] = true;
        }
        System.out.println(Arrays.toString(check));
        for(int i=0;i<10;i++)
        {
            
            if(!check[i])
            {
                System.out.println(i);
                answer +=i;
            }
        }
        
        return answer;
    }
}