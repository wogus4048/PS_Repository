import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.print.FlavorException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Prac_sesac {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test_case = Integer.parseInt(br.readLine());
    boolean[] check = new boolean[26];

    int result = 0;
    for (int i = 0; i < test_case; i++) {
      Boolean bad = false;
      String a = br.readLine();
      for (int j = 0; j < a.length(); j++) {
        if (check[(int) a.charAt(j) - 97] == true) {
          if (j != 0 && a.charAt(j) == a.charAt(j - 1)) {
            continue;
          } else {
            bad = true;
          }
        }
        check[(int) a.charAt(j) - 97] = true;

      }
      Arrays.fill(check, false);
      if (bad != true) {
        result += 1;
      }

    }
    bw.write(result + "\n");
    bw.flush();
    bw.close();
  }

}
