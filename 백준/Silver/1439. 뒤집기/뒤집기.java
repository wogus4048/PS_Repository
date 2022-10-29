
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        int result1 = 0;
        int result0 = 0;

        StringTokenizer st = new StringTokenizer(input,"0");
        result0 = st.countTokens();
        st = new StringTokenizer(input, "1");
        result1 = st.countTokens();

        if (result1 > result0) {
            bw.write(result0+"");
        }
        else{
            bw.write(result1+"");
        }





        bw.flush();
        bw.close();


    }



}
