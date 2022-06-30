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

    int test_case = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] numbers = new int[st.countTokens()];

    for (int i = 0; i < test_case; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numbers);

    for (int j = 1; j <= numbers[0]; j++) {
      int count = 0;

      for (int k = 0; k < test_case; k++) {
        if (numbers[k] % j == 0)
          count++;

      }
      if (count == test_case)
        bw.write(j + "\n");

    }

    bw.flush();
    bw.close();
  }

}
