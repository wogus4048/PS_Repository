import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num, max, min;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    num = Integer.parseInt(br.readLine());
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

  }

  public static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < num; i++) {
      int temp = Integer.parseInt(st.nextToken());

      if (temp > max) {
        max = temp;
      }
      if (temp < min) {
        min = temp;
      }

    }
    bw.write(String.format("%d %d", min, max));

  }

  static void test() throws IOException {

  }

}