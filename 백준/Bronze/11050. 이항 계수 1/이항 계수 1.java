import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


   static int n;
   static int k;
   static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        visited = new boolean[n];

        combination(0, 0);
        bw.write(result+"");

        bw.flush();
        bw.close();

    }

    public static void combination( int count,int depth) {
        if (count == k) { //다 선택한경우
            result++;
            return;
        }
        if (depth == n) {
            return;
        }
        visited[depth] = true;
        combination(count + 1, depth + 1);
        visited[depth] = false;
        combination(count, depth + 1);

    }



}