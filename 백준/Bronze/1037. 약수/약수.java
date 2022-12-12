import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> numberList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numberList.add(Integer.parseInt(st.nextToken()));
        }

        if (numberList.size() == 1) {
            bw.write((int)Math.pow(numberList.get(0), 2)+"");
        }
        else{
            numberList.sort(Comparator.naturalOrder());
            bw.write(numberList.get(0)*numberList.get(numberList.size()-1)+"");
        }

        bw.flush();
        bw.close();

    }

}