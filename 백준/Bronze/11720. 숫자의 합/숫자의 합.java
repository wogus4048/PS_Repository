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
    String[] arr = br.readLine().split("");

    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result += Integer.parseInt(arr[i]);
    }

    bw.write(result + "\n");

    bw.flush();
    bw.close();
  }

}
