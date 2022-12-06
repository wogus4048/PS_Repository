import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static String result = "666";
  static int count = 1;
  static int num = 666;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();
    bw.write(num + "\n");

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    while (count != n) {
      num++;
      if (Integer.toString(num).contains("666")) {
        count++;
      }

    }

  }

  static void test() throws IOException {

  }
}
