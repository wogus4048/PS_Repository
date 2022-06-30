import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int b = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      if (b == 0 && n == 0) {
        break;
      }

      for (int i = 1; i <= b; i++) {
        if (b == 1) {
          bw.write(1 + "\n");
          break;
        }
        if (n == 1) {
          bw.write(b + "\n");
          break;
        }
        if (b <= Math.pow(i, n)) {
          int result = Math.pow(i, n) - b >= b - Math.pow(i - 1, n) ? i - 1 : i;
          bw.write(result + "\n");
          break;
        }
      }

    }

    bw.flush();
    bw.close();
  }

}
