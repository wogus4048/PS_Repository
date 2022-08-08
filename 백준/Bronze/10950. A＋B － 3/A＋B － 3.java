import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num1, num2, test_case;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());

  }

  public static void solve() throws IOException {

    for (int i = 0; i < test_case; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      num1 = Integer.parseInt(st.nextToken());
      num2 = Integer.parseInt(st.nextToken());
      bw.write((num1 + num2) + "\n");

    }

  }

  static void test() throws IOException {

  }

}