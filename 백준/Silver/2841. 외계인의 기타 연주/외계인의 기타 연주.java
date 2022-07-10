import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static Stack<Integer> line1 = new Stack<>();
  static Stack<Integer> line2 = new Stack<>();
  static Stack<Integer> line3 = new Stack<>();
  static Stack<Integer> line4 = new Stack<>();
  static Stack<Integer> line5 = new Stack<>();
  static Stack<Integer> line6 = new Stack<>();
  static int count = 0;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());

  }

  static void solve() throws IOException {

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int line = Integer.parseInt(st.nextToken());
      int plat = Integer.parseInt(st.nextToken());
      switch (line) {
        case 1:
          hand_move(line1, plat);
          break;

        case 2:
          hand_move(line2, plat);
          break;

        case 3:
          hand_move(line3, plat);
          break;

        case 4:
          hand_move(line4, plat);
          break;

        case 5:
          hand_move(line5, plat);
          break;

        case 6:
          hand_move(line6, plat);
          break;

      }

    }
    bw.write(count + "\n");

  }

  static void test() throws IOException {

  }

  static void hand_move(Stack<Integer> line, int plat_number) throws IOException {
    while (true) {
      if (line.isEmpty()) {
        line.push(plat_number);
        count++;
        break;
      } else if (line.peek() > plat_number) {
        line.pop();
        count++;
      } else if (line.peek() < plat_number) {
        line.push(plat_number);
        count++;
        break;
      } else if (line.peek() == plat_number) {
        break;
      }

    }

  }
}
