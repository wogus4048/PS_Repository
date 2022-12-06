import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (check(n, i)) {
                return;
            }
        }
        bw.write(0+"");

        bw.flush();
        bw.close();

    }

    public static boolean check(int n, int number) throws IOException{
        char[] numberChar = Integer.toString(number).toCharArray();
        int sum =number;

        for (char currentNumber : numberChar) {
            sum += Character.getNumericValue(currentNumber);
        }
        if (sum == n) {
            bw.write(number + "");
            bw.flush();
            return true;
        }
        return false;

    }



}