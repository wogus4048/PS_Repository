import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static String a, b;
  static int row, col;
  static char[][] result;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = st.nextToken();
    b = st.nextToken();

    loop: for (int i = 0; i < a.length(); i++) {
      char current = a.charAt(i);
      for (int j = 0; j < b.length(); j++) {
        if (current == b.charAt(j)) {
          row = j; // 몇행에 A 문장이 놓여야하는지
          col = i; // 몇열에 B문장이 놓여야하는지
          break loop;
        }
      }
    }

    result = new char[b.length()][a.length()];

    for (int i = 0; i < b.length(); i++) {
      Arrays.fill(result[i], '.');
    }

  }

  static void solve() throws IOException {
    for (int i = 0; i < a.length(); i++) {
      result[row][i] = a.charAt(i);
    }
    for (int j = 0; j < b.length(); j++) {
      result[j][col] = b.charAt(j);
    }

    for (int i = 0; i < b.length(); i++) {
      for (int j = 0; j < a.length(); j++) {
        bw.write(result[i][j] + "");
      }
      bw.write("\n");
    }

  }

}
