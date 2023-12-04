
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
    static List<Member> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Member(i, Integer.parseInt(input[0]), input[1]));
            //순서 , 나이 ,이름순
        }

    }

    static void solve() throws IOException {

        list.sort((o1,o2) -> {
            if (o1.age == o2.age) {
                return o1.order - o2.order;
            }
            else{
                return o1.age - o2.age;
            }


        });

        for (Member currentM : list) {
            bw.write(currentM.age + " " + currentM.name+"\n");
        }

    }
    static class Member{
        int age;
        int order;
        String name;

        public Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

    }


}