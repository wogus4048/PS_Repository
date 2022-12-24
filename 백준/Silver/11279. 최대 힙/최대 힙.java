import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
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
            if (input == 0) {
                if (!priorityQueue.isEmpty()) {
                    bw.write(priorityQueue.poll() + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                priorityQueue.add(input);
            }
        }


    }

}