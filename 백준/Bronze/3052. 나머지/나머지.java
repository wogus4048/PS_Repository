import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashSet<Integer> set = new HashSet<>();

    int[] arr = new int[10];

    for (int i = 0; i < 10; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 0; i < 10; i++) {
      set.add(arr[i] % 42);
    }
    bw.write(set.size() + "\n");

    bw.flush();
    bw.close();
  }

}
