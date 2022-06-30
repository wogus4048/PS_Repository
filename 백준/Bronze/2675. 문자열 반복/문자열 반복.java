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

    int test_case = Integer.parseInt(br.readLine());

    for (int i = 0; i < test_case; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int number = Integer.parseInt(st.nextToken());
      String a = st.nextToken();
      String result = "";
      for (int j = 0; j < a.length(); j++) {
        for (int k = 0; k < number; k++) {
          result += a.charAt(j);
        }

      }
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
  }

}
