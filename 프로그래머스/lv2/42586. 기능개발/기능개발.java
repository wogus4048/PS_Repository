import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++)
        {
            int a = (int) ((100 - progresses[i]) / (double)speeds[i]); 
            //몇일이 지나야 완성되는지 n일을 구하는 식 (int)로 인해 소수점은 버려진다.
            
            double b = ((100 - progresses[i]) / (double)speeds[i]) - a;
            //n일을 넘어도 딱 100이되지않고 넘는다면 소수점이 남을것이다. 남으면 +1 
            
            if(b != 0)
            {
                q.add(a+1); // 큐에 걸리는 일자를 넣어준다.
                continue;
            }
            q.add(a);// 큐에 걸리는 일자를 넣어준다.
        }
        List<Integer> answerList = new ArrayList<>();
        boolean isPoll = false;
        int currentDay =0;
        int count =0;
        while(!q.isEmpty())
        {
            if(!isPoll)
            {
                currentDay = q.poll();
                count++;
                isPoll = true;
            }
            else{
                if(currentDay >= q.peek())
                {
                    q.poll();
                    count++;
                }
                else{
                    answerList.add(count);
                    isPoll = false;
                    count =0;
                }
            }
        }
        answerList.add(count);
        
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++)
        {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

/*
큐에 모든 작업을 넣는다. -> 완성되는데 걸리는 시간을 넣는다.
맨 앞의 기능이 완성되는 날을 구한다. 
그 날이 지났다고 가정하에 뽑고  +1
그다음 작업이 걸리는 시간이 앞의 뽑았던 기능의 작업시간보다 작거나 같다면 그것도 뽑고 +1
아니라면 결과에 저장
큐가 빌때까지 반복 
*/