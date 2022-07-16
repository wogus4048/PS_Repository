import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, max, min;
  static int[] numbers;
  static int[] operator;

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    operator = new int[4];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < 4; j++) {
      operator[j] = Integer.parseInt(st.nextToken());
    }
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

  }

  static void solve() throws IOException {
    dfs(numbers[0], 1);
    bw.write(max + "\n" + min);

  }

  static void dfs(int number, int used_number) throws IOException {
    if (used_number == n) {
      max = Math.max(max, number);
      min = Math.min(min, number);
      return;

    }

    for (int i = 0; i < 4; i++) {
      if (operator[i] > 0) {
        operator[i]--;

        switch (i) {
          case 0:
            dfs(number + numbers[used_number], used_number + 1);
            break;
          case 1:
            dfs(number - numbers[used_number], used_number + 1);
            break;
          case 2:
            dfs(number * numbers[used_number], used_number + 1);
            break;
          case 3:
            dfs(number / numbers[used_number], used_number + 1);
            break;
        }
        operator[i]++;
      }

    }

  }

}
