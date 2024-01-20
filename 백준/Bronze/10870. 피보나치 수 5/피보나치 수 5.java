

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
        int result = fibo(n);

        System.out.println(result);
    }

    static int fibo(int n) {
        if (n == 0 ) {
            return 0;
        }
        if (n == 1 ) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }







}