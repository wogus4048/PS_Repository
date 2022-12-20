import java.io.*;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */

    static int n;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
    }

    static void solve() throws IOException {
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                stack.push(Integer.parseInt(input[1]));
            }
            if (input[0].equals("top")) {
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.peek()+"\n");
                }

            }
            if (input[0].equals("size")) {
                bw.write(stack.size()+"\n");

            }if (input[0].equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0+"\n");
                }

            }if (input[0].equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop()+"\n");
                }

            }
        }

    }



}