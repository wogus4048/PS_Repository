import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> minpq = new PriorityQueue<>(); //최소힙
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙


        for(int i=0;i<operations.length;i++)
        {
            StringTokenizer st = new StringTokenizer(operations[i]); //띄어쓰기로 구분
            String next = st.nextToken();
            if(next.equals("I")) //숫자 삽입
            {
                int next_number = Integer.parseInt(st.nextToken());
                //둘다 넣어준다.
                minpq.add(next_number);
                maxpq.add(next_number);

            }else //삭제 일경우
            {
                if(minpq.size()<1) //비어있는데 삭제하라고 하면 넘어감
                {
                    continue;
                }

                int next_number = Integer.parseInt(st.nextToken());

                if(next_number == 1) //최대값 삭제라면
                {
                    int max = maxpq.poll(); //최대힙에서 하나 삭제해주고
                    minpq.remove(max); // 최소힙에서도 해당 값삭제

                }else {
                    int min = minpq.poll(); //최대힙에서 하나 삭제해주고
                    maxpq.remove(min); // 최소힙에서도 해당 값삭제

                }

            }
        }

        if(maxpq.isEmpty()) //큐가 비어있다면 --> [0,0] 리턴
        {
            return new int[]{0,0};
        }
        else{
            return new int[] {maxpq.peek(),minpq.peek()};
        }




    }

    public static void main(String[] args) {
        String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operation)) );


    }


}
