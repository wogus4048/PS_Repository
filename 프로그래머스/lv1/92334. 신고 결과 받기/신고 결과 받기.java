import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static String[] id_list = { "muzi", "frodo", "apeach", "neo" };

  static String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };

  ArrayList<String> temp = new ArrayList<>();

  static int k = 2;

  public static int[] solution(String[] id_list, String[] report, int k) throws IOException {
    int[] answer = {};
    answer = new int[id_list.length];
    Arrays.fill(answer, 0); // 모두 0으로 초기화해둠

    Map<String, Integer> index = new HashMap<>();

    for (int i = 0; i < id_list.length; i++) {
      index.put(id_list[i], i);
    }

    // for (String keyset : index.keySet()) {
    // int count = index.get(keyset);
    // bw.write(String.format("key : %s , count : %d \n", keyset, count));
    // }

    Set<String> set = new HashSet<String>(Arrays.asList(report)); // report 중복제거

    ArrayList<ArrayList<String>> list = new ArrayList<>();

    for (int i = 0; i < id_list.length; i++) {
      list.add(new ArrayList<>()); // 초기화
    }

    for (String temp : set) {
      StringTokenizer st = new StringTokenizer(temp);

      String reporter = st.nextToken();
      String reported = st.nextToken();
      // bw.write(String.format("1 :%s , 2 : %s \n", reporter, reported));
      // bw.write(String.format("인덱스 : %d\n", index.get(reported)));
      list.get(index.get(reported)).add(reporter);

    }

    // for (ArrayList<String> temp : list) {
    // int siz = temp.size();
    // String arr[] = temp.toArray(new String[siz]);
    // bw.write(Arrays.toString(arr) + "\n");
    // } 인접리스트 확인

    for (ArrayList<String> temp : list) {
      if (temp.size() >= k) // 신고횟수 체크
      {
        for (int i = 0; i < temp.size(); i++) {
          String name = temp.get(i);
          answer[index.get(name)] += 1;
        }
      }
    }

    // bw.write(Arrays.toString(answer) + "");
    return answer;
  }


}