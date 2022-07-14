import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int s;
  static boolean[] visited;
  static int[] arr;
  static int result = 0;
  static int temp;

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
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    arr = new int[n];
    visited = new boolean[n];

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st2.nextToken());
    }

  }

  static void solve() throws IOException {
    for (int i = 1; i <= n; i++) {
      Arrays.fill(visited, false);
      temp = 0;
      combo(n, i, 0, arr, visited);
    }
    bw.write(result + "");

  }

  static void combo(int n, int r, int start, int[] arr, boolean[] visited) throws IOException {
    if (r == 0) {
      if (temp == s) {
        result++;
        //print(n, arr, visited);
        return;
      }
    } else {
      for (int i = start; i < n; i++) {
        visited[i] = true;
        temp += arr[i];
        combo(n, r - 1, i + 1, arr, visited);
        temp -= arr[i];
        visited[i] = false;

      }

    }

  }

  static void print(int n, int[] arr, boolean[] visited) throws IOException {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (visited[i] == true) {
        sb.append(arr[i] + " ");
      }
    }
    bw.write(sb.toString() + "\n");
  }

  static void test() throws IOException {

  }

}
