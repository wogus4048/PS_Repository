import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num, count;
  static String base;
  static int[] alphabet = new int[26 + 1];

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    num = Integer.parseInt(br.readLine());
    count = 0;
    base = br.readLine();

    for (int i = 0; i < base.length(); i++) {
      int index = base.charAt(i) - 64; // A라면 1인덱스에 Z라면 26인덱스에
      alphabet[index] += 1;
    }

    // bw.write(Arrays.toString(alphabet) + "\n");

  }

  static void solve() throws IOException {

    for (int i = 1; i < num; i++) { // 첫번째 문장을 뺀 횟수만큼
      String temp = br.readLine();

      int total_modify = 0;
      // 첫번째 같은구성 조건이라면 , 즉 기준 문자열에서 알파벳 갯수를 수정할 필요가 없다.
      // 같은구성이면 일단 길이가 같을것이므로 길이 체크부터, 길이가 같을때 문자하나만 바꾸면 되는것도 체크해줌

      if (temp.length() == base.length()) {
        if (temp.length() == 1) {
          bw.write(1 + "\n");
          return;
        }
        int[] alphabet_temp0 = new int[26 + 1];

        for (int j = 0; j < temp.length(); j++) {// 해당 단어 알파벳 구성을 담아주고
          int index = temp.charAt(j) - 64;
          alphabet_temp0[index] += 1;
        }

        // bw.write(Arrays.toString(alphabet_temp0) + "\n");

        int gap = 0;
        for (int j = 1; j < alphabet_temp0.length; j++) {
          gap += Math.abs(alphabet[j] - alphabet_temp0[j]); // 각 알파벳 단어의 차이의 총 크기를 구해준다.
        }
        // gap의 차이가 2이라면 한단어만 교체하면됨 , gap 이 0이면 같은구성
        if (gap == 2 || gap == 0) {
          count++;
        }
        gap = 0;

      } else if (Math.abs(base.length() - temp.length()) == 1) { // 길이가 같지않은경우 하나의 문자를 더하거나 빼는경우에 같은 구성이 되는지 체크한다.
        // 길이 차이가 1이여야 빼거나 더할때 같은구성이 될가능성이있음
        int[] alphabet_temp = new int[26 + 1];
        for (int j = 0; j < temp.length(); j++) {// 해당 단어 알파벳 구성을 담아주고
          int index = temp.charAt(j) - 64;
          alphabet_temp[index] += 1;
        }

        // bw.write(Arrays.toString(alphabet_temp) + "\n");

        int gap = 0;
        for (int j = 1; j < alphabet_temp.length; j++) {
          gap += Math.abs(alphabet[j] - alphabet_temp[j]); // 각 알파벳 단어의 차이의 총 크기를 구해준다.
        }
        // gap의 차이가 1이라면 한단어만 추가하거나 빼면 된다.
        if (gap == 1) {
          count++;
        }
        gap = 0;

      }

    }

    bw.write(count + "");

  }

}
