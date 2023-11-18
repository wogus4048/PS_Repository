import java.util.*;
import java.math.*;
class Solution {
    public double[] solution(int x, int n) {
        double[] answer = new double[n];
        
        for(int i=1;i<=n;i++)
        {
            if(x ==0)
            {
                answer[i-1] = 0;
            }
            else
            {
                answer[i-1] = x * (double)i;
            }
        }
        
        
        return answer;
    }
}