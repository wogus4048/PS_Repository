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
    }

    static void solve() throws IOException {
        int size = 0;
        while(true) {
            int input = Integer.parseInt(br.readLine());
            if (input == -1) {
                break;
            }
            if (input == 0) {
                queue.poll();
                size--;
                continue;
            }
            if (size != n) {
                queue.add(input);
                size++;
            }

        }

        if (queue.isEmpty()) {
            bw.write("empty");
        } else {
            while (!queue.isEmpty()) {
                bw.write(queue.poll()+" ");
            }
        }

    }

}