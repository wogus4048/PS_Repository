import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static String k;
  static int result = 0;

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.write(result + "\n");
    bw.flush();
    bw.close();

  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    k = st.nextToken();

  }

  static void solve() throws IOException {
    int h = 0;
    int m = 0;
    int s = 0;

    String time = "000000";

    while (h <= n) {

      if (time.contains(k)) {
        result += 1;
      }

      ///
      if (++s == 60) {
        s = 0;
        if (++m == 60) {
          m = 0;
          h++;
        }
      }
      ///
      time = "";

      if (h < 10) {
        time += "0" + h;
      } else {
        time += h;
      }

      if (m < 10) {
        time += "0" + m;
      } else {
        time += m;
      }
      if (s < 10) {
        time += "0" + s;
      } else {
        time += s;
      }
      // bw.write(time + "\n");
    }

  }

}