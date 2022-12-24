import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    절댓값 순서대로 정렬을 하고,
    절대값이 가장 작은게 여러개일 경우 가장 작은값을 삭제해라 -> ex ( 절댓값 8이 가장 작은 절댓값일때 8과 -8이 있다면 -8을 삭제해라)

    음수를 저장하는 최대힙 우선순위큐를 만들어서 큰값이 우선순위가 높게끔 하고
    양수일때는 최소힙 우선순위큐를 만든다.

    0이나오면 양쪽에서 값을 하나씩 뽑아서 절대값으로 바꾼후 값을 비교한다.
    절대값이 더 작은쪽이 있다면 해당 우선순위큐에서 값을 제거하면서 출력한다.
    절대값이 같다면 음수쪽 우선순위큐에서 값을 제거하고 출력한다.
     */
    static PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder()); // 음수 우선순위큐
    static PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(); // 양수 우선순위큐
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

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input > 0) { //양수인경우
                positiveQueue.add(input);
            } else if (input < 0) { // 음수인경우
                negativeQueue.add(input);
            } else { //0인경우
                //둘다 비었을때는 0 출력
                //아니라면 한쪽만 비어있는 경우를 조심하며 비교한다.

                long negativeAbs = Integer.MIN_VALUE; // 값의 범위는 절대값으로 봄녀 음수가 양수보다 1더 크다는것을 잊으면 안된다. 
                long positiveAbs= Integer.MAX_VALUE;

                if (negativeQueue.isEmpty() && positiveQueue.isEmpty()) {
                    bw.write("0\n"); //0을 출력하고 반복문 다음으로 넘어가야한다.
                    continue;
                }
                if (!negativeQueue.isEmpty()) {
                    negativeAbs = negativeQueue.peek();
                }
                if (!positiveQueue.isEmpty()) {
                    positiveAbs = positiveQueue.peek();
                }
                negativeAbs = Math.abs(negativeAbs);
                positiveAbs = Math.abs(positiveAbs);

                if (negativeAbs > positiveAbs) { // 양수쪽이 절대값이 더 작다면 양수쪽 제거하고 출력
                    bw.write(positiveQueue.poll() + "\n");
                } else { //음수쪽이 절대값이 작거나, 절대값이 같은경우 음수쪽 제거하고 출력
                    bw.write(negativeQueue.poll() + "\n");
                }
            }

        }


    }

}