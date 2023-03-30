import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++)
        {
            int max =0 ;
            
            if( i == prices.length-1)
            {
                answer[i] = 0;
                break;
            }
            
            for(int j=i+1; j<prices.length;j++)
            {
                if(prices[i] > prices[j])
                {
                    max = j;
                    break;
                }
            }
            if(max == 0 )
            {
                max = prices.length-1;
            }
            answer[i] = max-i;
            
        }
        
        
        
        
        return answer;
    }
}

/*
총 기간동안 해당 가격이 얼마나 버티는지를 결과로 나타내라

각 위치에서 뒤쪽에 숫자와 비교하고 자기보다 작은숫자가 나올때까지 카운트하며 전진
나오면 결과를 반환 , 없으면 끝까지간후 숫자 반환

끝이면 그냥 0
이중반복문 으로 10만 * 10만 하면 10억이라 통과못할거같지만 시도
*/