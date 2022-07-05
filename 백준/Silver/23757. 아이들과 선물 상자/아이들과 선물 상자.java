import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int box;
  static int people;
  static PriorityQueue<Integer> high = new PriorityQueue<>(Collections.reverseOrder());
  static int[] arr;

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
    box = Integer.parseInt(st.nextToken());
    people = Integer.parseInt(st.nextToken());
    arr = new int[people];
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < box; i++) {
      high.add(Integer.parseInt(st2.nextToken()));
    }
    StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < people; i++) {
      arr[i] = Integer.parseInt(st3.nextToken());
    }

  }

  static void solve() throws IOException {
    for (int i = 0; i < people; i++) {
      if (high.peek() > arr[i]) {
        high.add(high.poll() - arr[i]);
      } else if (high.peek() > arr[i]) {
        high.remove();
      } else if (high.peek() < arr[i]) {
        bw.write(0 + "\n");
        bw.flush();
        bw.close();
        System.exit(0);
      }

    }
    bw.write(1 + "\n");

  }

  static void test() throws IOException {

  }
}
