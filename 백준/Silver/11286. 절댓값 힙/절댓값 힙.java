import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static PriorityQueue<data> a = new PriorityQueue<>();
  static int n;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        if (a.isEmpty()) {
          bw.write(0 + "\n");
        } else {
          bw.write(a.poll().real_data + "\n");
        }
      } else {
        a.add(new data(Math.abs(input), input));
      }

    }

  }

  static void test() throws IOException {

  }

}

class data implements Comparable<data> {
  int abs;
  int real_data;

  public data(int abs, int real_data) {
    this.abs = abs;
    this.real_data = real_data;
  }

  @Override
  public int compareTo(data another) {
    if (this.abs > another.abs) {
      return 1;
    }
    if (this.abs < another.abs) {
      return -1;
    } else if (this.abs == another.abs) {
      if (this.real_data > another.real_data) {
        return 1;
      } else if (this.real_data < another.real_data) {
        return -1;
      }
    }
    return 0;
  }
}
