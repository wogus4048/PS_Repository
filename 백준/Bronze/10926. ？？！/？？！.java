import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    input();
    solve();
    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {

  }

  public static void solve() throws IOException {
    String temp = br.readLine();

    bw.write(temp + "??!" + "\n");

  }

}