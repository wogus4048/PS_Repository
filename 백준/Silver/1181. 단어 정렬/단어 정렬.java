import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int n;
    static Set<String> set = new HashSet<>();
    static List<String> list ;

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        list = new ArrayList<>(set);



    }
    static void solve() throws IOException {

        list.sort((o1,o2) ->
        {
            if(o1.length() == o2.length())
            {
                return o1.compareTo(o2);

            }else{
                return o1.length() - o2.length();
            }

        });

        for (String s : list) {
            bw.write(s+"\n");

        }




    }






}