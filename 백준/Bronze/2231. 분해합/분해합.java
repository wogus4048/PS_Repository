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

    int a = Integer.parseInt(br.readLine());
    int b = 0;
    loop: for (int i = 1; i < a; i++) {

      int result = i;
      String[] temp = Integer.toString(i).split("");
      // bw.write(Arrays.toString(temp) + "\n");

      for (int j = 0; j < temp.length; j++) {
        result += Integer.parseInt(temp[j]);
        // bw.write(result + "\n");
      }
      if (result == a) {
        b = i;
        break loop;
      }

    }
    bw.write(b + "\n");

    bw.flush();
    bw.close();
  }

}
