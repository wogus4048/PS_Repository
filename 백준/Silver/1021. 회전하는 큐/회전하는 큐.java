import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int size;
  static int pick_counts;
  static ArrayList<Integer> numbers = new ArrayList<>();
  static int[] target;

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
    size = Integer.parseInt(st.nextToken());
    pick_counts = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= size; i++) {
      numbers.add(i);
    }
    target = new int[pick_counts];
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

    for (int j = 0; j < pick_counts; j++) {
      target[j] = Integer.parseInt(st2.nextToken());
    }

  }

  static void solve() throws IOException {
    int count = 0;
    for (int i = 0; i < pick_counts; i++) {
      int target_number = target[i];
      while (true) {
        int current_numbers_size = numbers.size();

        if (numbers.get(0) == target_number) {
          // bw.write("제거\n");
          numbers.remove(0);
          break;
        }
        int left_gap = numbers.indexOf(target_number);
        int right_gap = (current_numbers_size - 1) - numbers.indexOf(target_number);
        // bw.write(String.format("현재 리스트 크기 : %d, 타겟넘버 : %d, 왼쪽갭 : %d, 오른쪽 갭 ; %d \n",
        // current_numbers_size,
        // target_number, left_gap, right_gap));
        if (right_gap == 0) {
          int temp = numbers.get(current_numbers_size - 1);
          numbers.remove(current_numbers_size - 1);
          numbers.add(0, temp);
          count++;
          // bw.write(String.format("오른쪽이동 , 현재 리스트 크기 : %d, 현재 count : %d",
          // numbers.size(), count));
        } else if (left_gap > right_gap) {
          int temp = numbers.get(current_numbers_size - 1);
          numbers.remove(current_numbers_size - 1);
          numbers.add(0, temp);
          count++;
          // bw.write(String.format("오른쪽이동 , 현재 리스트 크기 : %d, 현재 count : %d",
          // numbers.size(), count));
        } else if (left_gap <= right_gap) { // 위치가 정 중앙이라면 왼쪽으로 이동하는게 더빠르다. ( 맨오른쪽으로 가면 +1 번해야 0인덱스로 가므로)
          int temp = numbers.get(0);
          numbers.remove(0);
          numbers.add(current_numbers_size - 1, temp);
          count++;
          // bw.write(String.format("왼쪽이동 , 현재 리스트 크기 : %d, 현재 count : %d",
          // numbers.size(), count));

        }
      }
    }
    bw.write(count + "\n");

  }

  static void test() throws IOException {

  }

}
