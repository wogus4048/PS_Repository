import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            map.put(Integer.parseInt(st.nextToken()),0);
        }
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            if (map.containsKey(input)) {
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}