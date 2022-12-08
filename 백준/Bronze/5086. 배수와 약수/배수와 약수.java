import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (num1 == 0 && num2 == 0) {
                break;
            }
            if (num1 % num2 == 0) {
                bw.write("multiple\n");
                continue;
            }
            else if (num2 % num1 == 0) {
                bw.write("factor\n");
            }
            else{
                bw.write("neither\n");
            }

        }
        bw.flush();
        bw.close();

    }

}