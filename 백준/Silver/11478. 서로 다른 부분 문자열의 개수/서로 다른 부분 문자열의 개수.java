import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

    }
    static void solve() throws IOException {
        Set<String> set = new HashSet<>();

        String words = br.readLine();
        int size = words.length();
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < size; j++) {
                if (j + i <= size) {
                    set.add(words.substring(j, j + i));
                }
            }
        }

        bw.write(set.size()+"");


    }
}