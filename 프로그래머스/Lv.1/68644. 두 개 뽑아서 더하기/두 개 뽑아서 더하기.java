import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        /*
        완전탐색으로 모든 경우의수 구해서
        중복 제거를 위한 Set에 저장,
        Set을 이용해서 List만들고 정렬
        */
        int length = numbers.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length-1;i++)
        {
            for(int j=i+1;j<length;j++)
            {
                int temp = numbers[i] + numbers[j];
                set.add(temp);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        
        list.sort(Comparator.naturalOrder());
        
        
        return list;
    }
}