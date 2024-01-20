import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxV = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for(int[] size : sizes)
        {
            int cMax = Math.max(size[0],size[1]);
            int cMin = Math.min(size[0],size[1]);
            
            maxH = Math.max(maxH,cMax);
            maxV = Math.max(maxV,cMin);
            // System.out.println(maxH+" "+maxV);
        }
        
        answer = maxH * maxV;
        
        
            
            
            
        return answer;
    }
}
    
    /*
    가로와 세로 길이를 비교해서 세로가 더 길다면 가로로 취급,
    즉 가로 세로 길이중 더 큰것을 가로, 작은것을 세로
    가로중 가장 큰값, 세로중 가장 큰값 구해서 곱
    */