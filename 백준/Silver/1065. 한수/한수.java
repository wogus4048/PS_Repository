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
  static int count = 99;
  static int number = 100;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();
    if (n <= 99) {
      bw.write(n + "\n");
    } else {

      bw.write(count + "\n");
    }

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {

    if (n <= 99) {
      return;
    }

    while (number <= n) {
      String temp = Integer.toString(number);
      int a = Integer.parseInt("" + temp.charAt(temp.length() - 2))
          - Integer.parseInt("" + temp.charAt(temp.length() - 1));
      int temp_num = 0;
      // bw.write(String.format("number : %d, count: %d, a : %d, temp_num : %d,
      // temp.length:%d \n", number, count, a,
      // temp_num, temp.length()));
      for (int i = temp.length() - 1; i >= 0; i--) {
        // bw.write(String.format(" i : %d \n", i));
        if (i != 0) {
          int minus = (Integer.parseInt("" + temp.charAt(i - 1)) - Integer.parseInt("" + temp.charAt(i)));
          // bw.write(String.format("앞 %d 뒤 %d 차이 %d, a: %d\n", Integer.parseInt("" +
          // temp.charAt(i - 1)),
          // Integer.parseInt("" + temp.charAt(i)),
          // minus, a));
          // bw.write(" minus : %d , a : %d \n", minus, a);
          if (minus == a) {
            temp_num++;
          }
          // bw.write(String.format("number : %d, count: %d, a : %d, temp_num : %d,
          // temp.length:%d \n", number, count, a,
          // temp_num, temp.length()));

        }

      }
      if (temp_num == (temp.length() - 1)) {
        count++;
      }
      number++;

    }

  }

  static void test() throws IOException {

  }
}
