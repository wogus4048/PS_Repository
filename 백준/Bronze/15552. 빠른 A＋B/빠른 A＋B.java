import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
      String[] arr = br.readLine().split(" ");
      bw.write(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]) + "\n");
    }
    bw.flush();
    bw.close();
  }

}
