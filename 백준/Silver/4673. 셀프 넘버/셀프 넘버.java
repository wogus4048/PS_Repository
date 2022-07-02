import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static boolean[] check = new boolean[10001];

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();
    // bw.write(count + "\n");
    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    Arrays.fill(check, false);

  }

  static void solve() throws IOException {
    for (int i = 1; i < 10000; i++) {
      dd(i);
    }
    for (int i = 1; i < 10000; i++) {
      if (check[i] == false) {
        bw.write(i + "\n");
      }
    }

  }

  static void dd(int number) {
    int total = number;
    String temp = Integer.toString(number);
    for (int i = 0; i < temp.length(); i++) {
      total += Integer.parseInt("" + temp.charAt(i));
    }
    if (total <= 10000) {
      check[total] = true;
    }

  }

  static void test() throws IOException {
    String a = "55";
    int b = 10;
    b += Integer.parseInt("" + a.charAt(0));
    bw.write(b + "\n");

  }
}
