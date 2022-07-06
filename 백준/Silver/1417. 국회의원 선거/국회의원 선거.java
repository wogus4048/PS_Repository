import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int number;
  static int Dasom;
  static int[] another;
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
    number = Integer.parseInt(br.readLine());
    another = new int[number - 1];
    Dasom = Integer.parseInt(br.readLine());
    if (number == 1) {
      bw.write("0");
      bw.flush();
      bw.close();
      System.exit(0);
    }
    // 다솜이를 제외하고 나머지 후보자들의 득표수를 배열에 넣어준다.
    for (int i = 0; i < number - 1; i++) {
      another[i] = Integer.parseInt(br.readLine());
    }
  }

  static void solve() throws IOException {
    while (true) {
      int max = 0;
      int max_index = 0;
      for (int i = 0; i < number - 1; i++) {
        if (another[i] > max) {
          max = another[i];
          max_index = i;
        }
      }

      if (Dasom <= another[max_index]) {
        another[max_index]--;
        count++;
        Dasom++;

      } else if (Dasom > another[max_index]) {
        bw.write(count + "\n");
        break;
      }

    }
  }

  static void test() throws IOException {

  }
}
