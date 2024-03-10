import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        
        List<Integer> list =  new ArrayList<>();
        
        for(int num : arr)
        {
            if(num % divisor ==0) list.add(num);
        }
        if(list.size() ==0) 
        {
            list.add(-1);
            return list;
        }
        list.sort(Comparator.naturalOrder());
        
        
        return list;
    }
}