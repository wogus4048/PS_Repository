import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */
    static int n;
    static Deque<Integer> queue = new LinkedList<>();

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
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                queue.add(Integer.parseInt(input[1]));
            }if (input[0].equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.poll()+"\n");
                }

            }if (input[0].equals("size")) {
                bw.write(queue.size()+"\n");

            }if (input[0].equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0+"\n");
                }
            }if (input[0].equals("front")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.peek()+"\n");
                }

            }if (input[0].equals("back")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.getLast()+"\n");
                }

            }

        }


    }



}
