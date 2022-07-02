import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;

  public static void main(String[] args) throws IOException {

    // test();
    input();
    solve();

    bw.write(n + "\n");

    bw.flush();
    bw.close();

  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    String temp = "";

    while (n >= 4) {
      Boolean check = true;
      temp = Integer.toString(n);
      // bw.write("n:" + n);
      for (int i = 0; i < temp.length(); i++) {
        if (temp.charAt(i) != '4' && temp.charAt(i) != '7') {
          n--;
          check = false;
          break;
        }

      }
      if (check) {
        break;
      }

      // bw.write("n:" + n);
    }

  }

}
