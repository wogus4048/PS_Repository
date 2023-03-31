import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(String oper : operations)
        {
            String[] op = oper.split(" ");
            if(op[0].equals("I")){
                maxQ.add(Integer.parseInt(op[1]));
            }
            else{
                if(op[1].equals("1"))
                {
                    maxQ.poll();
                }
                else{
                    minQ.addAll(maxQ);
                    minQ.poll();
                    maxQ.clear();
                    maxQ.addAll(minQ);
                    minQ.clear();
                }
                
            }
        
        }
        
        if(maxQ.size()>=2)
        {
            int max = maxQ.poll();
            minQ.addAll(maxQ);
            int min = minQ.poll();
            return new int[] {max,min};
            
        }
        else if(maxQ.size() ==0 )
        {
            return new int[] {0,0};
        }
        
        
        return answer;
    }
}

/*


*/