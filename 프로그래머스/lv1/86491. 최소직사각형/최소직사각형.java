import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int wide = sizes[0][0];
        int height =sizes[0][1];

        
        for(int i =1; i< sizes.length;i++)
        {
            int[] current =sizes[i];
            int w1 = Math.max(wide ,current[0]); 
            int h1 = Math.max(height ,current[1]); 
            
            int w2 = Math.max(wide , current[1]);
            int h2 = Math.max(height , current[0]);
            
            if((w1 * h1) > (w2 * h2) )
            {
                wide =w2;
                height =h2;
            }
            else{
                wide =w1;
                height =h1;
            }
        }
        
        return wide * height;
        
        
    }
}

/*

*/