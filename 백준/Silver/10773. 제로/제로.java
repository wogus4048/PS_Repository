import java.io.*;

import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */
    static int n;
    static int sum;
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
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
            } else {
                stack.add(input);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum+"");

    }



}