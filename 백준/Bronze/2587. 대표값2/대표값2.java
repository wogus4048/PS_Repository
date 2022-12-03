
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        List<Integer> numberList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int currentInputNumber = Integer.parseInt(br.readLine());
            numberList.add(currentInputNumber);
            sum += currentInputNumber;
        }

        Collections.sort(numberList);

        bw.write(sum/5+"\n"+numberList.get(2));



        bw.flush();
        bw.close();


    }


}