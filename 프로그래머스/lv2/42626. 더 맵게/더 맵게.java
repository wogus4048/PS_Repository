import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 해결책 1 -> 효율성테스트 탈락
     * 받은 스코빌 배열을 정렬하고 시작
     * 정렬한 후 첫번째 원소(음식)가 K보다 크다면 다음에 나올 음식들도 K스코빌보다 크니 멈추고 0을 리턴
     *
     *
     * 마지막까지 섞다가 요소가 한개남았는데 K보다 작다면 만들수 없는 경우 이므로 -1를 리턴
     * 한번 만들고 정렬하고를 반복
     *
     * 해결책 2 -> 우선순위 큐 최소힙구현
     *
     * */
    int[] scovile = {1, 2, 3, 9, 10, 12};
    int k =  7;


    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++)
        {
            minHeap.add(scoville[i]);
        }

        while(minHeap.size()>1)
        {
            if(minHeap.peek() >= K)
            {
                return answer;
            }

            int first = minHeap.poll();
            int second = minHeap.poll();
            minHeap.add(first+(second*2));

            answer++;

        }

        if(minHeap.poll() < K)
        {
            return -1;
        }





//        실패한 해결책
//        List<Integer> sco
//                = Arrays.stream(scoville).boxed().collect(Collectors.toList()); // primitive 타입인 int를 리스트로 변환하기
//
//
//        while(sco.size()>1) //요소가 1개일때까지 반복
//        {
//
//            Collections.sort(sco);// 오름차순 정렬
//            if(sco.get(0) >= K) // 첫번째 요소가 k보다 나머지도 K보다 클테니까 반복 종료
//            {
//                return answer;
//            }
//            int first = sco.get(0);
//            sco.remove(0);
//
//            int second = sco.get(0);
//            sco.remove(0);
//
//            int new_food = first + (second*2);
//            sco.add(new_food); //맨뒤에 새로만든거 저장.
//
//            answer++;
//
//
//        }
//
//        //요소가 1개일때
//        if(sco.get(0)<K) //한개있는게 k보다 작다면 -1을 리턴
//        {
//            return -1;
//        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(s.scovile, s.k)) ;

    }


}
