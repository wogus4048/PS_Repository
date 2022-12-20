import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    문자열의 길이는 20만 ,문제의 수도 20만, 인덱스 범위도 20만까지니까 반복문을 이용하면 시간초과가 날것같다.
    어떻게해야 연산수를 줄일 수 있을까?
    일단 물어보는것은 해당 인덱스범위에 나오는 특정 문자의 갯수이다. 즉 i,j 범위라고 치면 j까지 특정문자의 총 갯수합 - i까지 특정문자의 총 갯수합 이다.
    각 알파벳에 대해 a-z까지 문자열 각 인덱스에 대한 특정문자 합을 저장해두면 되지않을까? dp[26][n]  문자열 길이 * 알파벳 갯수 만큼

     */
    static int dp[][];
    static int q;
    static String input;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        input = br.readLine();
        q = Integer.parseInt(br.readLine());
        dp = new int[26][input.length()];

    }

    static void solve() throws IOException {
        checkSum();
        for (int i = 0; i < q; i++) {
            String[] question = br.readLine().split(" ");
            int questionAscii = (int) question[0].charAt(0) - 97;
            int indexI = Integer.parseInt(question[1]);
            int indexJ = Integer.parseInt(question[2]);
            if (indexI == 0) {
                bw.write(dp[questionAscii][indexJ] + "\n");
            }
            else{
                bw.write(dp[questionAscii][indexJ] - dp[questionAscii][indexI - 1] + "\n");
            }
        }


    }

    static void checkSum ()  throws IOException{
        //자바에서 int 기본값을 0으로 따로 초기화할필요없다.
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            int currentAscii = (int) currentCharacter - 97; // a는 0 부터 z는 25 인덱스를 가지게끔

            dp[currentAscii][i] += 1; //해당 문자의 dp배열에 값을 증가 시킨다.
            if (i != 0) {
                for (int j = 0; j < 26; j++) {
                    //이전 인덱스값과 현재값을 더해 현재 인덱스값으로 초기화해줌으로서 해당위치에 문자갯수합을 저장해준다.
                    dp[j][i] += dp[j][i-1];
                }
            }
        }

//        for (int[] a : dp) {
//            bw.write(Arrays.toString(a) + "\n");
//        }
    }


}