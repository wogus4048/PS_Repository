import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */
    static int n;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write(1+"");
        }
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    static void solve() throws IOException {
        while (queue.size()>=2) {
            queue.poll();
            if (queue.size() == 1) {
                bw.write(queue.poll() + "");
                break;
            } else {
                queue.add(queue.poll());
            }
        }
    }

}
