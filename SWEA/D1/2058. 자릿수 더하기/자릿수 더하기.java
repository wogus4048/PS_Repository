import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    String temp = br.readLine();
    int result = 0;
    for (int i = 0; i < temp.length(); i++) {
      result += temp.charAt(i) - '0';
    }

    bw.write(result + "\n");
    bw.flush();
    bw.close();

  }

}