import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {

  }

  static void solve() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), "-");
    StringBuilder sb = new StringBuilder();

    while (st.hasMoreTokens()) {
      sb.append(st.nextToken().charAt(0));
    }
    bw.write(sb.toString() + "");

  }

  static void test() throws IOException {

  }

}
