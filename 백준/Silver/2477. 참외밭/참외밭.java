import java.io.*;
import java.util.Arrays;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] inputData;
    static int k;
    static int maxX=0;
    static int maxY =0;
    static int xIndex,yIndex;

    /*
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        k = Integer.parseInt(br.readLine());
        inputData = new int[6][2];
        for (int i = 0; i < 6; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            inputData[i] = new int[]{input[0], input[1]};
            if (input[0] == 1 || input[0] == 2) {
                if (maxX < input[1]) {
                    maxX = input[1];
                    xIndex = i;
                }
            }
            if (input[0] == 3 || input[0] == 4) {
                if (maxY < input[1]) {
                    maxY = input[1];
                    yIndex = i;
                }
            }
        }
    }
    static void solve() throws IOException {

        int y1,y2;
        int x1,x2;

        if (xIndex + 1 > 5) {
            y1 = 0;
        } else {
            y1 = xIndex + 1;
        }
        if (xIndex - 1 < 0) {
            y2 = 5;
        } else {
            y2 = xIndex - 1;
        }


        int emptyY = Math.abs(inputData[y1][1] - inputData[y2][1]);

        if (yIndex - 1 < 0) {
            x1 = 5;
        } else {
            x1 = yIndex - 1;
        }
        if (yIndex + 1 > 5) {
            x2 = 0;
        } else {
            x2 = yIndex + 1;
        }


        int emptyX = Math.abs(inputData[x1][1] - inputData[x2][1]);

        int answer = (maxX*maxY) - (emptyX*emptyY) ;
        System.out.println(answer*k);

    }
}