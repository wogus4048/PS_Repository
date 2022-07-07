import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static int M;
  static HashSet<String> N_people = new HashSet<>();
  static ArrayList<String> Result = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      N_people.add(br.readLine());
    }

  }

  static void solve() throws IOException {
    String temp = "";
    for (int i = 0; i < M; i++) {
      temp = br.readLine();
      if (N_people.contains(temp)) {
        Result.add(temp);
      }

    }
    Collections.sort(Result);
    bw.write(Result.size() + "\n");
    for (int j = 0; j < Result.size(); j++) {
      bw.write(Result.get(j) + "\n");
    }

  }

  static void test() throws IOException {

  }

}
