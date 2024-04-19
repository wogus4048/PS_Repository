import java.util.*;
class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<score.length;i++)
        {
            list.add(score[i]);
            list.sort(Comparator.reverseOrder());
            if(i<k)
            {
                answer.add(list.get(list.size()-1));
            }
            else{
            
                answer.add(list.get(k-1));
            }
            
        }
        
        return answer;
    }
}