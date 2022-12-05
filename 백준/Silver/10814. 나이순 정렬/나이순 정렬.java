import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            members.add(new Member(i, Integer.parseInt(input[0]), input[1]));
        }

        members.sort((o1,o2) -> {
            if (o1.age == o2.age) {
                return o1.memberNumber - o2.memberNumber;
            }
            else{
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(members.get(i).age + " " + members.get(i).name+"\n");
        }

        bw.flush();
        bw.close();

    }

    static class Member {

        int memberNumber;
        int age;
        String name;

        public Member(int memberNumber, int age, String name) {
            this.memberNumber = memberNumber;
            this.age = age;
            this.name = name;
        }
    }
}