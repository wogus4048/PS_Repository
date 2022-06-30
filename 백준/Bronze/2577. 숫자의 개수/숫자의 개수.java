import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    String number = Integer.toString(a * b * c);
    int[] arr = new int[10];

    Arrays.fill(arr, 0);

    for (int i = 0; i < number.length(); i++) {
      arr[Character.getNumericValue(number.charAt(i))] += 1;
    }

    for (int i = 0; i < arr.length; i++) {
      bw.write(arr[i] + "\n");
    }

    bw.flush();
    bw.close();

  }

}
