import java.io.*;
import java.util.Arrays;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int testcase;

    /*
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        testcase = Integer.parseInt(br.readLine());

    }
    static void solve() throws IOException {
        for (int i = 0; i < testcase; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] start = new int[]{input[0], input[1]};
            int[] end = new int[]{input[2], input[3]};
            int answer =0;
            int planetCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < planetCount; j++) {
                int[] planetInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (checkPosition(start, planetInfo) && checkPosition(end, planetInfo)) {
                    //둘다 그 행성계안에 있다면 넘어간다.
                    continue;
                }
                else if (checkPosition(start, planetInfo) || checkPosition(end,planetInfo)) { //출발지 또는 도착지가 현재 행성계안에 존재한다면 지나야하는 행성계값 추가
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }

    static boolean checkPosition(int[] position, int[] planet) {
        //해당 좌표가 행성안쪽에 존재하는건지 체크
        int positionX = position[0];
        int positionY = position[1];
        int planetX = planet[0];
        int planetY = planet[1];
        int planetR = planet[2];

        //두점 사이 거리가 , 행성계의 반지름보다 작다면 행성계안에 존재하는 점이고, 크다면 행성계 밖에 존재하는점이다.
        if (Math.pow((double) planetX - positionX, 2) + Math.pow((double) planetY - positionY, 2)
            < Math.pow(planetR, 2)) {
            return true;
        }
        return false;
    }
}