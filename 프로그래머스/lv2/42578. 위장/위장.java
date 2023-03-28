import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes)
        {
            String category = cloth[1];
            map.put(category,map.getOrDefault(category,0)+1);
        }
        System.out.println(map);
        
//         List<Integer> valueList = new ArrayList<>(map.values());
//         //values()는 Collection객체로 리턴되므로 List에 담아서 list로 사용한다.

        
        for(int count : map.values())
        {
            answer *= (count+1);
        }
        
        
        return answer-1;
    }
}

/*
Map<카테고리,갯수>로 정리 한 후 

각 카테고리 갯수+1 를 서로 곱해준다. 그리고 하나도 입지않는경우를 빼준다 (-1)

*/