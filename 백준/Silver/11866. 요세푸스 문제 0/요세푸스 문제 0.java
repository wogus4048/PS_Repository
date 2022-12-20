import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    큐를 이용해서 풀 수 있을거같다. 일단 n명의 사람들을 순서대로 큐에 넣고
    k번 될때까지 맨앞에 사람을 뒤로 보낸다.(큐 poll 후 다시 add) 그리고 k번째 사람은 그냥 poll해서 출력
    큐의 사이즈가 1이 되면 그사람은 그냥 poll하면서 출력
     */
    static int n;
    static int k;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        k = Integer.parseInt(input[1]);

    }

    static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count =0;
        while (queue.size() > 1) {
            if (count == k-1) {
                sb.append(queue.poll()).append(", ");
                count=0;
                continue;
            }
            queue.add(queue.poll());
            count ++;
        }

        sb.append(queue.poll()).append(">");
        bw.write(sb.toString());



    }

}