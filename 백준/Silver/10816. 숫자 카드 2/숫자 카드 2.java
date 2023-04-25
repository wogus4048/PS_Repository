

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,m;
    static Map<Integer,Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {


    }
    static void solve() throws IOException {

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(input[i]), map.getOrDefault(Integer.parseInt(input[i]), 0) + 1);
        }

        m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            if (map.containsKey(Integer.parseInt(input2[i]))) {
                bw.write(map.get(Integer.parseInt(input2[i]))+" ");
            } else {
                bw.write(0+" ");
            }
        }


    }



}


