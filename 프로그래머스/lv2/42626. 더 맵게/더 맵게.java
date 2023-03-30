import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int s : scoville)
        {
            q.add(s);
        }
        
        while(true)
        {
            int firstScovile = q.poll();
            
            if(firstScovile >= K)
            {
                break;
            }
            
            if(q.isEmpty())
            {
                return -1;
            }
            
            int secondScovile = q.poll();
            

            if( secondScovile == 0)
            {
                return -1;
            }
            
            q.add(firstScovile + (2 * secondScovile));
            answer ++;

        }
        
        
        return answer;
    }
}

/*
매번 스코빌지수가 가장 낮은 2개를 뽑고 , 조리 후 다시 넣어야하므로
우선순위큐 최소힙을 사용한다.

제일 스코빌 작은 음식을 뽑았는데 k보다 크거나 같다면 종료

스코빌이 모두 0이면 어떻게든 k이상만들수없다.
-> 두번째로 스코빌이 작은 음식이 0이라면 -1 
-> 즉 스코빌 가장작은 2개 음식이 둘다 0이라면 뭘 더 할 수없음  
k가 0인경우도 있으므로 뽑은걸 먼저 체크해야함
*/