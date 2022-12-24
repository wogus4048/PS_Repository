import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */
    static PriorityQueue<Integer> absPriorityQueue; //절대값 우선순위큐
    static int n;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        absPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) { //절대값이 같다면
                    return o1 - o2; // 값 자체로 비교해서 오름차순
                } else {
                    return Math.abs(o1) - Math.abs(o2); // 아니면 절대값으로 비교해서 오름차순
                }
            }
        });
    }

    static void solve() throws IOException {

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (absPriorityQueue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(absPriorityQueue.poll() + "\n");
                }
            } else {
                absPriorityQueue.add(input);
            }

        }


    }

}