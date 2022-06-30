import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ArrayList<String> al0 = new ArrayList<>();
    ArrayList<String> al1 = new ArrayList<>();
    StringBuffer temp0 = new StringBuffer();
    StringBuffer temp1 = new StringBuffer();

    String a = br.readLine();
    for (int i = 0; i < a.length(); i++) {

      if (a.charAt(i) == '0') {
        if (temp1.length() != 0) {
          al1.add(temp1.toString());
          temp1.setLength(0);
        }
        temp0.append("0");
      }

      if (a.charAt(i) == '1') {
        if (temp0.length() != 0) {
          al0.add(temp0.toString());
          temp0.setLength(0);
        }
        temp1.append("1");
      }

    }
    if (temp0.length() != 0) {
      al0.add(temp0.toString());
    } else if (temp1.length() != 0) {
      al1.add(temp1.toString());
    }

    // Iterator iter0 = al0.iterator();
    // Iterator iter1 = al1.iterator();
    // while (iter0.hasNext()) {
    // bw.write("0인부분:" + iter0.next() + "\n");
    // }
    // while (iter1.hasNext()) {
    // bw.write("1인부분:" + iter1.next() + "\n");
    // }

    int result = 0;
    if (al0.size() == 0 | al1.size() == 0) {
      result = 0;
    } else {
      result = Math.min(al0.size(), al1.size());
    }

    bw.write(result + "\n");

    bw.flush();
    bw.close();
  }

}
