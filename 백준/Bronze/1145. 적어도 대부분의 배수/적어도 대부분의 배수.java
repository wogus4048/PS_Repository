import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] arr = new int[5];
  static int count = 0;
  static int max = 100 * 99 * 98;

  public static void main(String[] args) throws IOException {

    // test();
    input();
    solve();

    bw.write(count + "\n");

    bw.flush();
    bw.close();

  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

  }

  static void solve() throws IOException {
    while (count < max) {
      count++;
      int check = 0;
      for (int number : arr) {
        if (count % number == 0) {
          // bw.write(String.format("number : %d , count : %d , check : %d\n", number,
          // count, check));
          check++;
        }
      }
      if (check >= 3) {
        break;
      }
    }

  }

  // static void test() throws IOException {
  //   bw.write(2 % 10 + "\n");
  // }

}
