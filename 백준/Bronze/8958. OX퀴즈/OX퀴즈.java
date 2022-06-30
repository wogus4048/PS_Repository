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

    int test_case = Integer.parseInt(br.readLine());
    for (int i = 0; i < test_case; i++) {
      String arr = br.readLine();
      int count = 1;
      int result = 0;
      for (int j = 0; j < arr.length(); j++) {
        if (arr.charAt(j) == 'O') {
          result += count;
          count += 1;
          // bw.write("현재알파벳O:" + arr.charAt(j) + "현재총합:" + result + "현재 count:" + count +
          // "\n");
        } else if (arr.charAt(j) == 'X') {
          count = 1;
          // bw.write("현재알파벳X:" + arr.charAt(j) + "현재총합:" + result + "현재 count:" + count +
          // "\n");
        }
      }
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
  }

}
