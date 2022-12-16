import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    어떤 규칙이 있나 살펴보면 f(n) = f(n-1) + f(n-5)의 규칙을 알 수 있다.
    예를들어 7이 어떻게 구해졌나 보면 바로 뒤숫자인 5와 , 5번째전인 2와 합쳐져서 생성된다.
    규칙을 찾았으니 규칙을 가지고 메모이제이션을 진행해서 풀이해보자.
     */

    static int testcase;
    static int n;
    static long[] memoization = new long[101];

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        testcase = Integer.parseInt(br.readLine());
        //기저 상태 넣어놓기
        memoization[1] = 1;
        memoization[2] = 1;
        memoization[3] = 1;
        memoization[4] = 2;
        memoization[5] = 2;
        memoization[6] = 3;
    }

    static void solve() throws IOException {
        for (int i = 0; i < testcase; i++) {
            n = Integer.parseInt(br.readLine());
            bottomUp(n);
            bw.write(memoization[n]+"\n");
        }
    }

    static void bottomUp(int n) {
        for (int i = 7; i <=n; i++) {
            if (memoization[i] == 0) { // 다른 테스트케이스 덕분에 이미 채워져있을수도 있으니까.
                memoization[i] = memoization[i - 1] + memoization[i - 5];
            }
        }
    }
}