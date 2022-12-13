import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int sum =1; //결과를 저장할 변수
            Map<String, Integer> result = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String[] input = br.readLine().split(" ");
                result.put(input[1], result.getOrDefault(input[1], 0) + 1);
            }
            //입고 안입고에 대한 모든 경우를 생각  - 모두 안입는경우인 1개의 경우 빼주기
            for (int value : result.values()) {
                sum *= (value + 1);
            }
            bw.write(sum-1+"\n");
        }

        bw.flush();
        bw.close();

    }

}