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
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int p1 = Integer.parseInt(st.nextToken());
    int p2 = Integer.parseInt(st.nextToken());

    int min = 10000;
    for (int i = 0; i < 10000; i++) {

      for (int j = 0; j < 10000; j++) {
        if (p1 + x * i == p2 + y * j) {
          if (min > p1 + x * i) {
            min = p1 + x * i;
          }
        }

      }
    }
    if (min == 10000) {
      bw.write(-1 + "\n");
    } else {
      bw.write(min + "\n");
    }

    bw.flush();
    bw.close();
  }

}
