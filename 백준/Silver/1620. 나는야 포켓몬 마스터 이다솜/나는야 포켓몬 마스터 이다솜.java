import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        String[] indexPoket = new String[n+1];

        for (int i = 1; i <= n; i++) {
            String inputPoket = br.readLine();
            map.put(inputPoket, i);
            indexPoket[i] = inputPoket;
        }
        for (int i = 0; i < m; i++) {
            String examString = br.readLine();
            if (map.containsKey(examString)) {
                bw.write(map.get(examString) + "\n");
            }else{
                bw.write(indexPoket[Integer.parseInt(examString)] + "\n");
            }

        }



        bw.flush();
        bw.close();

    }
}