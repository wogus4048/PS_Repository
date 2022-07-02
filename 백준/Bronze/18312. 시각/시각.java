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

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    String k = st.nextToken();
    int result = 0;

    for (int i = 0; i <= n; i++) {
      String check2 = String.format("%02d", i);
      if (check2.contains(k)) {
        result += 3600;
      } else {
        for (int j = 0; j < 60; j++) {
          for (int a = 0; a < 60; a++) {
            String check = String.format("%02d", i) + String.format("%02d", j) + String.format("%02d", a);
            if (check.contains(k)) {
              result += 1;
            }
          }
        }
      }
    }

    bw.write(result + "\n");
    bw.flush();
    bw.close();
  }

}
