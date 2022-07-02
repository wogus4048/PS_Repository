import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    int[] arr = new int[n];
    for (int a = 0; a < n; a++) {
      arr[a] = Integer.parseInt(st2.nextToken());
    }

    int min = m;
    int result = 0;
    int temp = 0;

    for (int i = 0; i <= n - 3; i++) {
      // bw.write("i:" + i + "\n");
      for (int j = i + 1; j <= n - 2; j++) {
        // bw.write("j:" + j + "\n");
        for (int k = j + 1; k <= n - 1; k++) {
          // bw.write(arr[i] + " " + arr[j] + " " + arr[k] + "\n");
          temp = m - (arr[i] + arr[j] + arr[k]);
          // bw.write("k:" + k + "\n" + "temp:" + temp + "min" + min + "\n");
          if (temp >= 0 && temp < min) {
            min = temp;
            result = arr[i] + arr[j] + arr[k];
            // bw.write("m과 3값의합의 차이 최소값 :" + min + "현재 그 합:" + result + "\n");
          }

        }
      }
    }
    bw.write(result + "\n");

    bw.flush();
    bw.close();
  }

}
