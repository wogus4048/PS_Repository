import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,m;
    static Set<Integer> set;




    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }

    }

    static void solve() throws IOException {

        m = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(input[i]);
            if (set.contains(num)) {
                sb.append(1 + " ");
            }
            else{
                sb.append(0 + " ");
            }
        }

        bw.write(sb.substring(0, sb.length() - 1));



    }



}