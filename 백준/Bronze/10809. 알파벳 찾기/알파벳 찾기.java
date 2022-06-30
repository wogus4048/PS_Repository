import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String a = br.readLine();

    int[] count = new int[26];

    Arrays.fill(count, -1);

    for (int i = 0; i < a.length(); i++) {
      int temp = (int) a.charAt(i) - 97;
      
      if (count[temp] == -1) {
        count[temp] = i;
      }

    }
    for (int j = 0; j < count.length; j++) {
      bw.write(count[j] + " ");
    }

    bw.flush();
    bw.close();
  }

}
