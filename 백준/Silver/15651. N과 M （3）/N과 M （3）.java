import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    /**
     * 중복 순열
     * 중복을 막는 방문배열을 없앤다.
     */

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int[] result = new int[r];
        permutation(n, r,  result, 0);
        bw.flush();
        bw.close();

    }

    public static void permutation(int n, int r,int[] result,int count) throws  IOException{
        if (count == r) {
            for (int i = 0; i < r; i++) {
                bw.write(result[i] + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            result[count] = i + 1; //결과값을 저장할때 인덱스는 지금까지 뽑은갯수여야만 한다.
            permutation(n, r,result,count+1);
        }

    }

}