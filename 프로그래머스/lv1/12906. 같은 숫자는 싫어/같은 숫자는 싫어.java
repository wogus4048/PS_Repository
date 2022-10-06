import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> a = new ArrayList<>();

        for(int i=0;i<arr.length;i++)
        {
            int temp = arr[i];
            if(i+1 < arr.length && arr[i+1] == temp)
            {
                continue;
            }
            else{
                a.add(temp) ;
            }
        }

        int[] answer = new int[a.size()];

        for(int j=0;j<a.size();j++)
        {
            answer[j] = a.get(j);
        }


        return answer;
    }
}