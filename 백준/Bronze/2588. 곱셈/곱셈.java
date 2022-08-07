import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static String num1, num2;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    num1 = br.readLine();
    num2 = br.readLine();

  }

  public static void solve() throws IOException {
    for (int i = 1; i <= num1.length(); i++) {
      bw.write(String.format("%d\n", Integer.parseInt(num1) * (num2.toCharArray()[num2.length() - i] - '0')));
    }
    bw.write(String.format("%d", Integer.parseInt(num1) * Integer.parseInt(num2)));

  }

  static void test() throws IOException {

  }

}