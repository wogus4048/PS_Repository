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
  static int test_case;
  static int count;

  public static void main(String[] args) throws IOException {

    input();
    solve();

    // bw.write(count + "\n");
    bw.flush();
    bw.close();

  }

  static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    for (int i = 0; i < test_case; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      count = 0;

      for (int j = a; j <= b; j++) {
        String temp = Integer.toString(j);
        for (int k = 0; k < temp.length(); k++) {
          if (temp.charAt(k) == '0') {
            count++;
          }
        }

      }
      bw.write(count + "\n");

    }

  }

}
