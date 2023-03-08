import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String,Integer> items = new HashMap<>();
        for(int i=0; i< want.length; i++)
        {
            items.put(want[i],number[i]);
        }
        
        
        //check loop
        
        Map<String,Integer> temp = new HashMap<>();
        boolean answerCheck = true;
        
        for(int i=0; i<discount.length;i++)
        {
            if(i+9 < discount.length)
            {
                    for(int j = i; j < i + 10; j++)
                {
                    temp.put(discount[j],temp.getOrDefault(discount[j] , 0) +1 );
                    
                }
                

                for(int k=0;k<want.length;k++)
                {
                    if(items.get(want[k]) != temp.get(want[k]))
                    {
                        answerCheck = false;
                        break;
                    }
                }
                if(answerCheck)
                {
                    answer ++;
                }
                answerCheck = true;
                temp.clear();
            }
        }
            
        return answer;
    }
}

