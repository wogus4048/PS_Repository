import java.util.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> answerList = new ArrayList<>();
        
        for(int[] command : commands)
        {
            int first = command[0]-1;
            int end = command[1]-1;
            int k = command[2]-1;
            
            List<Integer> splitList = new ArrayList<>();
            
            for(int i=first; i<=end; i++)
            {
                splitList.add(array[i]);
            }
            System.out.println("분리:"+ splitList.toString());
            
            splitList.sort(Comparator.naturalOrder());
            
            answerList.add(splitList.get(k));
            
        }
        
        for(int i=0;i<answer.length;i++)
        {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}