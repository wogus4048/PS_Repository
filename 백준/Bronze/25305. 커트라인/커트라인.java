import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> scoreList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            scoreList.add(Integer.parseInt(st.nextToken()));
        }

        scoreList.sort(Comparator.reverseOrder());
        bw.write(scoreList.get(k - 1)+"\n");
        
        bw.flush();
        bw.close();
    }
}