import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //P1 + p5 = p6
    //p2 + p6 = p7
    //p3 + p6 = p8
    // ... 반복


    static long[] pado = new long[101];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            bw.write(getPado(Integer.parseInt(br.readLine()))+"\n");
        }

        bw.flush();
        bw.close();

    }

    public static long getPado(int n) {
        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 1;
        pado[4] = 2;
        pado[5] = 2;

        int start = 1;
        for (int i = 6; i <= n; i++) {
            pado[i] = pado[start] + pado[i - 1];
            start++;
        }
        return pado[n];

    }



}