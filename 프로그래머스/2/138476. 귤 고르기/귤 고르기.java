import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
     /*
     크기별로 몇개있는지 체크하고, 가장 많은것부터 정렬한다.
     원하는갯수에 대해 크기별 가장 많은것부터 감소해나가면서
     총 몇종류의 크기만 나가면 되는지 체크한다.
     
     최대 이진트리를 이용하면 될듯함.
     */
        Map<Integer,Integer> map = new HashMap<>();
        for(int c : tangerine)
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        // for(int value : map.values().stream().mapToInt(Integer::intValue).toArray()){
        //     System.out.println(value);
        // }
        
       int [] result =  map.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        int count =0;
        for(int i=result.length-1;i>=0;i--)
        {
            k -= result[i];
            count ++;
            if(k <=0) return count;
        }
        return count;
        
    }
    
    
}

