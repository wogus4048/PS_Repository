import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.Popup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static HashMap<String, Integer> map = new HashMap<>();

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    N = Integer.parseInt(br.readLine());
  }

  static void solve() throws IOException {
    String temp = "";
    map.put(br.readLine(), 1);
    for (int i = 0; i < N - 1; i++) {
      temp = br.readLine();
      if (map.containsKey(temp)) {
        map.replace(temp, map.get(temp) + 1); // 해당 책의 판매수를 증가시켜줌
      } else {
        map.put(temp, 1);
      }

    }
    int max_count = 0;
    for (String key : map.keySet()) {
      if (map.get(key) > max_count) {
        max_count = map.get(key);
      }
    }
    ArrayList<String> best_seller = new ArrayList<>();
    for (String key : map.keySet()) {
      if (map.get(key) == max_count) {
        best_seller.add(key);
      }
    }
    Collections.sort(best_seller);
    bw.write(best_seller.get(0) + "\n");

  }

  static void test() throws IOException {

  }
}
