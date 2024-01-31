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
    static int[] memoization;



    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {


    }

    static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        memoization = new int[n+1];
        Arrays.fill(memoization, -1);
//        bottomUp(n);

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        memoization[0] = 0;
        memoization[1] = 1;
        topDown(n);
        System.out.println(memoization[n]);


    }

    static void bottomUp(int n) {

        for (int i = 2; i <= n; i++) {
            memoization[i] = memoization[i - 1] + memoization[i - 2];
        }

    }

    static int topDown(int n) {

        if (memoization[n] == -1) {
            memoization[n] = topDown(n - 1) + topDown(n - 2);
        }
        return memoization[n];
    }



}