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

    int t = Integer.parseInt(br.readLine());

    int[] count = new int[3];
    Arrays.fill(count, 0);

    // 300초 60초 10초
    while (t > 0) {
      if (t % 10 != 0) {
        bw.write(-1 + "\n");
        bw.flush();
        bw.close();
        return;
      }
      if (t / 300 > 0) {
        count[0] = t / 300;
        t = t - (300 * (t / 300));
      }
      if (t / 60 > 0) {
        count[1] = t / 60;
        t = t - (60 * (t / 60));
      }
      if (t / 10 > 0) {
        count[2] = t / 10;
        t = t - (10 * (t / 10));
      }

    }
    for (int i = 0; i < 3; i++) {
      bw.write(count[i] + " ");
    }
    bw.flush();
    bw.close();
  }

}
