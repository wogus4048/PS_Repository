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

    ArrayList<Integer> arr = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      arr.add(Integer.parseInt(br.readLine()));
      sum += arr.get(i);
    }
    int temp = sum - 100;

    loop: for (int j = 0; j < 7; j++) {

      for (int k = 1; k < 9; k++) {
        if (arr.get(j) + arr.get(k) == temp) {
          // bw.write("출력:" + arr.get(j) + arr.get(k) + "\n");
          Integer a = arr.get(j);
          Integer b = arr.get(k);
          arr.remove(a);
          arr.remove(b);
          break loop;
        }

      }
    }
    arr.sort(Comparator.naturalOrder());

    for (Integer i : arr) {
      bw.write(i + "\n");
    }
    bw.flush();
    bw.close();
  }

}
