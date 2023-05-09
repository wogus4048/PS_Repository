

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


    static int testcase;

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {



    }
    static void solve() throws IOException {
        testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                String category = br.readLine().split(" ")[1];

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int result =1;
            for (String key : map.keySet()) {
                result *= (map.get(key) + 1);
            }
            System.out.println(result - 1);

        }

    }




}


