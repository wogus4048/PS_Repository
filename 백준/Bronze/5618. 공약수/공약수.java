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

    int[] check = new int[numbers[0] + 1];

    Arrays.fill(check, 0);

    for (int number : numbers) {
      for (int j = 1; j <= numbers[0]; j++) {
        if (number % j == 0) {
          check[j] += 1;
          // bw.write("현재 j :" + j + "현재 check[j]:" + check[j] + "\n");
        }
      }
    }
    for (int k = 1; k < check.length; k++) {
      if (check[k] == test_case) {
        bw.write(k + "\n");
      }
    }

    bw.flush();
    bw.close();
  }

}
