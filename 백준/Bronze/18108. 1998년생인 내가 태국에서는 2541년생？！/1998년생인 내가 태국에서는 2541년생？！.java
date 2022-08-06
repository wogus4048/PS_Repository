import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    num = Integer.parseInt(br.readLine());

  }

  public static void solve() throws IOException {
    System.out.println((num - 543) + "");

  }

  static void test() throws IOException {

  }

}