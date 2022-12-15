import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //팩토리얼 문제 , 팩토리얼은 상당히 큰수를 만들게된다.
    //여기서는 n이 최대 500이다. 500!는 상상도 못할 큰수일것이다. 팩토리얼 계산사이트에 500!를 입력해보니 너무큰숫자이다.
    //이 숫자는 int이든 long이든 담을 수 없다.
    //그럴때 사용하는것이 BigInteger이다. BigInteger는 문자열로 숫자를 받기때문에 , 숫자의 범위가 무한대이다.
    //BigInteger를 이용해서 여러방법으로 팩토리얼을 계산해보자.

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String result = facto(BigInteger.valueOf(n)).toString();
        int count =0;
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') {
                count++;
            }
            else{
                break;
            }
        }
        bw.write(count+"");
        
        bw.flush();
        bw.close();

    }

    public static BigInteger facto(BigInteger n) {
        //단순하게 반복문을 이용하는 방법
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= n.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


}