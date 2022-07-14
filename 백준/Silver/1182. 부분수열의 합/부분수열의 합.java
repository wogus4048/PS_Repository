import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int s;
  static int[] arr;
  static int count = 0;

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

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st2.nextToken());
    }

  }

  static void solve() throws IOException {
    dfs(0, 0);
    if (s == 0) // s가 0인 경우, dfs에서 아무런 숫자를 선택하지않았을때 count가 증가하므로
    {
      count--; // 해당 값을 뺴주기 위함
      bw.write(count + "");
    } else {
      bw.write(count + "");
    }

  }

  static void dfs(int index, int sum) throws IOException {
    if (index == n) {
      if (sum == s) {
        count++;
        return;
      }
    } else {
      dfs(index + 1, sum + arr[index]);// 지금 인덱스 값을 선택하는 경우 , 지금 인덱스 값을 sum에 더하고 다음 인덱스로 이동
      dfs(index + 1, sum);// 지금 인덱스 값을 선택하지 않는 경우, 지금 인덱스 값을 sum에 더하지않고 다음 인덱스로 이동
      // 위에 2개의 명령문을 실행하는 순간 2가지의 가지가 계속 생긴다 (트리구조가 생성됨)

    }

  }

  static void test() throws IOException {

  }

}
