
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input); // 기본구분자는 공백이다.
        int a = Integer.parseInt(st.nextToken()); // 고정비용
        int b = Integer.parseInt(st.nextToken()); // 가변비용
        int price = Integer.parseInt(st.nextToken());

        if(b >= price) // 가변비용보다 가격이 낮거나 같다면 , 아무리 만들어 팔아도 손익분기점을 넘을 수 없다.
        {
            bw.write(-1+"\n");
        }
        else{ //그게아니라면 구할 수 있음.
            // a + b*? > price*?   =>   a > (price-b) * ? =>  a / (price-b) > ?
            int temp = price -b ;
            int result = a/temp;
            bw.write( result + 1 +"\n"); // result는 10이다.

        }

        bw.flush();
        bw.close();



    }



}
