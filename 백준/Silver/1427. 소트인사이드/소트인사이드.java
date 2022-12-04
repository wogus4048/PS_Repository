import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Integer[] numberArray = new Integer[input.length()];

        for (int i = 0; i < input.length(); i++) {
            numberArray[i] = Character.getNumericValue(input.charAt(i));
        }

        Arrays.sort(numberArray, Comparator.reverseOrder());

        for (int number : numberArray) {
            bw.write(number+"");
        }
        

        bw.flush();
        bw.close();

    }
}