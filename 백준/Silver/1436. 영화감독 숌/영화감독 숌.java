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

    static int n;




    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write(666 + "");
            return;
        }

    }

    static void solve() throws IOException {
        int count =1;
        int num = 666;
        while (count < n) {
            num++;
            if (Integer.toString(num).contains("666")) {
                count++;
                if (count == n) {
                    bw.write(num+"");
                    break;
                }
            }

        }
    }



}