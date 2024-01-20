import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numberList.add(Integer.parseInt(br.readLine()));
        }

        numberList.sort(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            bw.write(numberList.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}