import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;

        List<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]); // 첫번째값을 넣어둔다.
        
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] == arr[i-1])
            {
                continue;
            }
            answerList.add(arr[i]);
        }
        
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++)
        {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
/*
1.
배열을 순서대로 돌면서 현재 인덱스의 숫자가 이전 인덱스의 숫자와 같은경우 
정답배열에 넣지않고, 이전 인덱스의 숫자와 같지않다면 정답배열에 넣는다.

2.
스택을 이용 

스택에 첫번째값을 넣는다.
그 후로 arr을 다돌때까지반복
스택에서 peek한 숫자와 현재 index숫자가 같으면 넣지않고 다음으로 이동
indext숫자와 같지않으면 스택에 넣는다. 

거꾸로 된 상태일것이니까 다시 빼서 뒤집는다.

3. 큐를 이용
스택처럼 행동하지만 앞에서 뺄수있으므로 편하다.

*/