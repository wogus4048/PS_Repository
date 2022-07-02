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
    int arr[] = new int[10];
    int temp = 0;
    int temp2 = 0;
    int min = 100;
    int result = 0;
    for (int i = 0; i < 10; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int j = 0; j < 10; j++) {
      temp += arr[j];
      temp2 = Math.abs(100 - temp);

      if (min >= temp2) {
        min = temp2;
        result = temp;

      }

    }
    bw.write(result + "\n");

    bw.flush();
    bw.close();
  }

}
