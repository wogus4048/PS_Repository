import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int people;
  static int jump_count;
  static ArrayList<Integer> circle = new ArrayList<>();

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
    people = Integer.parseInt(st.nextToken());
    jump_count = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= people; i++) {
      circle.add(i);
    }
    if (circle.size() == 1) {
      bw.write(String.format("<%d>", circle.get(0)));
      bw.flush();
      bw.close();
      System.exit(0);
    }

  }

  static void solve() throws IOException {
    int index = 0;
    bw.write("<");
    for (int i = 0; i < people - 1; i++) {

      for (int j = 0; j < jump_count - 1; j++) {
        index++;
        if (index > circle.size() - 1) {
          index = index - circle.size();
        }
      }
      bw.write(String.format("%d, ", circle.get(index)));
      circle.remove(index);
      if (index > circle.size() - 1) {
        index = index - circle.size();
      }

      if (circle.size() == 1) {
        bw.write(String.format("%d>", circle.get(0)));
        break;
      }

    }

  }

  static void test() throws IOException {

  }

}
