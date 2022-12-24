import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    외치는 수가 10만개나 된다. 이중반복문을 이용하면 시간초과가 될것이다.
    우선순위큐 2개를 이용해서 구현해본다, 중앙 값을 뽑아내기위해
    왼쪽에는 최대힙을 이용한 우선순위큐
    오른쪽에는 최소힙을 이용한 우선순위큐를 이용한다.
    홀수번째 수의 입력이면 왼쪽에 값을 넣고,
    짝수번째 수의 입력이면 오른쪽에 값을 넣는다.

    왼쪽에 값을넣고, 왼쪽의 가장큰값(우선순위가 가장높은값)과 오른쪽의 가장 작은값(우선순위가 가장높은값)을 비교해서 왼쪽의 값이 더 크다면 각각 큐에서 값을 빼서 바꿔 넣어준다.
    오른쪽에 값을 넣을때도 , 오른쪽 최소값이 왼쪽 최대값보다 작을때 각각 값을 빼서 나눠 넣어준다.
     */
    static PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> rightQ = new PriorityQueue<>();
    static int n;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (i % 2 != 0) { // 홀수번째 수를 입력시 왼쪽 우선순위큐에 삽입하고, 왼쪽 최대값과 오른쪽 최소값 비교해서 다르면 스위치
                leftQ.add(input);
                changeNumber();
                bw.write(leftQ.peek() + "\n");
            } else {
                rightQ.add(input);
                changeNumber();
                bw.write(leftQ.peek()+"\n");
            }
        }



    }

    static void changeNumber() { // 왼쪽 최대값과 오른쪽 최소값을 비교해서 왼쪽이 더 크면 각각 값을꺼내 바꿔 넣어준다. -> 왼쪽이든 오른쪽이든 값을 넣어줄때마다 실행
        if (!leftQ.isEmpty() && !rightQ.isEmpty()) { //둘다 비어있지않아야한다. 한쪽이라도 비어있으면 아무일도 일어나지않음
            int leftNumber = leftQ.peek();
            int rightNumber = rightQ.peek();

            if (leftNumber > rightNumber) {
                leftNumber = leftQ.poll();
                rightNumber = rightQ.poll();
                leftQ.add(rightNumber);
                rightQ.add(leftNumber);
            }
        }

    }

}