import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) ;
            int b = Integer.parseInt(input[1]);

            bw.write(lcm(a, b)+"");
            bw.newLine();
        }
      

        bw.flush();
        bw.close();

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b); //재귀적으로 실행되면서 마지막에 최대공약수를 가지고 리턴될것이니까 return을 붙여준다.
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


}