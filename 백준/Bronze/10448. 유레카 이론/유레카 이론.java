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
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test_case = Integer.parseInt(br.readLine());

    for (int i = 0; i < test_case; i++) {
      boolean check = false;
      int number = Integer.parseInt(br.readLine());
      loop: for (int a = 1; a <= number / 2; a++) {
        for (int b = 1; b <= number / 2; b++) {
          for (int c = 1; c <= number / 2; c++) {
            if (number == T(a) + T(b) + T(c)) {
              // bw.write(String.format("a:%d b:%d c: %d \n", a, b, c));
              // bw.write("number: " + number + "Ta: " + T(a) + "Tb: " + T(b) + "Tc " + T(c) +
              // "\n");
              check = true;
              break loop;
            }
          }
        }

      }
      if (check == true) {
        bw.write(1 + "\n");
      } else {
        bw.write(0 + "\n");
      }

    }

    bw.flush();
    bw.close();
  }

  static int T(int number) {
    int result = number * (number + 1) / 2;
    return result;
  }

}
