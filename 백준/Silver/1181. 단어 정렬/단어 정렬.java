
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        Set<String> arraySet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arraySet.add(br.readLine());
        }
        String[] array = arraySet.toArray(new String[0]);

        Arrays.sort(array, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return 0;
            } else {
                return o1.length() - o2.length();
            }

        });

        for (String current : array) {
            bw.write(current + "\n");
        }

        bw.flush();
        bw.close();

    }
}