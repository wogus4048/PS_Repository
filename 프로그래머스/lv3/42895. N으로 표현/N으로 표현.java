import java.util.*;

class Solution {
    private static int answer = Integer.MAX_VALUE;
    private static int n;
    private static int target;
    public int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0,0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int count, int prev){
        if(count >8){
            answer = -1;
            return;
        }
        if(prev == target){
            answer = Math.min(answer, count);
            return;
        }
        int nTemp =n;
        for(int i =0;i<8-count;i++){
            int newCount = count +i+1;
            dfs(newCount, prev + nTemp);
            dfs(newCount, prev - nTemp);
            dfs(newCount, prev * nTemp);
            dfs(newCount, prev / nTemp);
            
            nTemp = nTemp*10+n;
        }
    }
    
}