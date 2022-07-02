import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
      temp = Integer.toString(n);

      if (temp.contains("0")) {
        n--;
        continue;
      } else if (temp.contains("1")) {
        n--;
        continue;
      } else if (temp.contains("2")) {
        n--;
        continue;
      } else if (temp.contains("3")) {
        n--;
        continue;
      } else if (temp.contains("5")) {
        n--;
        continue;
      } else if (temp.contains("6")) {
        n--;
        continue;
      } else if (temp.contains("8")) {
        n--;
        continue;
      } else if (temp.contains("9")) {
        n--;
        continue;
      } else {
        break;
      }

    }

  }

}
