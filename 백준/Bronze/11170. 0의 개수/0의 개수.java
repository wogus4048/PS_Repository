import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int test_case;
  static int count;

  public static void main(String[] args) throws IOException {

    input();
    solve();

    // bw.write(count + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    // bw.write(test_case + "\n");
    for (int i = 0; i < test_case; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      count = 0;

      for (int j = a; j <= b; j++) {

        int temp = j;
        // bw.write(temp + "\n");
        if (temp == 0) {
          count++;
        }
        while (temp != 0) {
          if ((temp % 10) == 0) {
            count++;
          }
          temp = temp / 10;
        }

      }
      bw.write(count + "\n");

    }

  }

}
