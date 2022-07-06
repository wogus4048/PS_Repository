import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.stream.events.EntityReference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static HashMap<String, Integer> hash = new HashMap<>();
  static ArrayList<String> al = new ArrayList<>();

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
    String name = "";
    String status = "";
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      name = st.nextToken();
      status = st.nextToken();
      if (status.equals("enter")) {
        hash.put(name, 1);
      }
      if (status.equals("leave")) {
        hash.put(name, 0);
      }
    }
    Iterator<String> iter = hash.keySet().iterator();

    // 아직 회사에 있는사람들을 List에 옮겨담는다.
    while (iter.hasNext()) {
      String key = iter.next();
      if (hash.get(key) == 1) {
        al.add(key);
      }
    }
    // 내림차순으로 정렬
    Collections.sort(al, Collections.reverseOrder());

    // 리스트 출력
    for (int j = 0; j < al.size(); j++) {
      bw.write(al.get(j) + "\n");
    }

  }

  static void test() throws IOException {

  }
}
