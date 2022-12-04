import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Character[] charArray = new Character[input.length()];

        for (int i = 0; i < input.length(); i++) {
            charArray[i] = input.charAt(i);
        }
        Arrays.sort(charArray, Comparator.reverseOrder());

        for (char current : charArray) {
            bw.write(current+"");
        }


        bw.flush();
        bw.close();

    }
}