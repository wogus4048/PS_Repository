import java.util.*;
class Solution {
    
    public String solution(String s) {
        String answer = "";
        
        List<Integer> list = new ArrayList<>();
        for(String currentNumber : s.split(" "))
        {
            int n = Integer.parseInt(currentNumber);
            list.add(n);
        }
        list.sort(Comparator.naturalOrder());
        
        answer += list.get(0) + " " + list.get(list.size()-1);
        
        
        return answer;
    }
}