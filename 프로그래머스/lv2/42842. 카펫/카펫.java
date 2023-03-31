import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        
        int sum = brown + yellow;
        List<Integer> a = new ArrayList<>();
    
        for(int i=1;i<=sum;i++)
        {
            if(sum % i ==0)
            {
                a.add(i);
            }
        }
        
        int left = 1;
        int right = a.size()-2;
        while(left != right)
        {
            int cW = a.get(right);
            int cH = a.get(left);
            System.out.println(cW +", "+cH);
            if(yellow == (cW-2)*(cH-2))
            {
                return new int[]{cW,cH};
            }
            
            left += 1;
            right -= 1;
        }
        
        return new int[]{ a.get(a.size()/2),a.get(a.size()/2) };
    
        // if(a.size() % 2 ==0)
        // {
        //     return new int[]{a.get((a.size()/2)) , a.get( (a.size()/2)-1)};
        // }else
        // {
        //     return new int[]{ a.get(a.size()/2),a.get(a.size()/2) };
        // }
        
  
    }
}

/*
*/