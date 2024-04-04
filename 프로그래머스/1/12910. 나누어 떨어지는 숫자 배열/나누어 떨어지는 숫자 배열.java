import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
//         List<Integer> list =  new ArrayList<>();
        
//         for(int num : arr)
//         {
//             if(num % divisor ==0) list.add(num);
//         }
//         if(list.size() ==0) 
//         {
//             list.add(-1);
//             return list;
//         }
//         list.sort(Comparator.naturalOrder());
        
        
//         return list;
        
        int[] result = Arrays.stream(arr).filter((v) -> v%divisor == 0).sorted().toArray();
        return result.length!=0 ? result : new int[]{-1};
    }
}