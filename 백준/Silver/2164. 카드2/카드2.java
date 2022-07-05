import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static Queue<Integer> qq = new LinkedList<>();

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    for (int i = 1; i <= n; i++) {
      qq.add(i);
    }
    while (qq.size() > 2) {
      qq.remove();
      qq.add(qq.poll());

    }
    if (qq.size() == 2) {
      qq.remove();
      bw.write(qq.peek() + "\n");
    } else if (qq.size() == 1) {
      bw.write(qq.peek() + "\n");
    }

  }

  static void test() throws IOException {

  }
}
