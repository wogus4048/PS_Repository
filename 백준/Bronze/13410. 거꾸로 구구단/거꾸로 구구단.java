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

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int arr[] = new int[k];
    for (int i = 1; i <= k; i++) {
      String temp = Integer.toString(n * i);
      // bw.write(String.format("뒤집기전 temp : %s \n", temp));
      temp = new StringBuffer(temp).reverse().toString();
      // bw.write(String.format("뒤집기후 temp : %s \n", temp));
      arr[i - 1] = Integer.parseInt(temp);
    }
    Arrays.sort(arr);
    bw.write(arr[arr.length - 1] + "\n");

    bw.flush();
    bw.close();
  }

}
