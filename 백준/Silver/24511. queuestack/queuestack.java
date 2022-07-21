import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, m;
  static int[] A, B, input;
  static Deque<Integer> dec;

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

    A = new int[n];
    B = new int[n];
    dec = new ArrayDeque<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }

    m = Integer.parseInt(br.readLine());
    input = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      if (A[i] == 0) {
        dec.add(B[i]); // S는 어차피 그냥 넘기기만 하니까 큐만 저장.
      }

    }

    // for (int i = 0; i < n; i++) {
    // list.get(i).print();
    // }

  }

  static void solve() throws IOException {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      int input_num = input[i];
      // 리스트안에 큐가있다면 제일마지막 큐의 원소값만 뽑아온다.

      if (dec.isEmpty()) {
        // 스택뿐이였다는것이고 들어온값 그대로 나감
        sb.append(input_num + " ");
      } else {// 비어있지않다는것 , 새로운값은 덱의 왼쪽으로 저장하고 , 오른쪽에 있는값을 pop해준다.
        dec.addFirst(input_num);
        sb.append(dec.pollLast() + " ");

      }

    }

    bw.write(sb.toString() + " ");

  }

  static class data {
    char d;
    int value;

    public void set_d(char d) {
      this.d = d;
    }

    public void set_value(int value) {
      this.value = value;
    }

    public void print() throws IOException {
      bw.write(String.format("d : %c , value : %d\n", this.d, this.value));
    }
  }

}
