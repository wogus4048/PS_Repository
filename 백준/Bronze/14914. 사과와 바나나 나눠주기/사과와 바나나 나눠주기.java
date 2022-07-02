import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int a;
  static int b;

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    bw.close();

  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

  }

  static void solve() throws IOException {
    int min = a > b ? b : a;

    for (int i = 1; i <= min; i++) {

      if (a % i == 0 && b % i == 0) {
        bw.write(String.format("%d %d %d \n", i, a / i, b / i));
      }

    }

  }

}
