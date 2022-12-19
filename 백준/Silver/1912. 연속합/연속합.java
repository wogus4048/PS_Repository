import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    n개의 수가 주어지고, 그 숫자들중 연속된 몇개 수를 선택해서 최대값을 구한다. 최소 한개 이상 선택해야한다.
    정수의갯수는 최대 10만개, 10만개를 1개뽑는,2개뽑는...n개뽑는 조합을 모두구해서 최대값을 구하면 무조건 시간초과 조합 -> O(2^n)
    해당 위치의 숫자와, 그 숫자를 더했을때 어떤값이 더큰지 체크한다, 그렇게함으로서 그 숫자를 선택하지않았을때와, 그 숫자를 선택했을 2경우의 최대값을 체크할 수 있다.
    각 숫자에 도착했을때 뽑고,안뽑고의 둘중 최대값을 구해보는것이므로 모든경우를 확인한다고 볼 수 있다.(연속된 수를 뽑는 문제니까)

     */

    static int n;
    static int[] numbers;
    static int[] sums;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        sums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
    }

    static void solve() throws IOException {
        int tempSum = numbers[0];
        sums[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            int tempMax = Math.max(numbers[i], numbers[i] + tempSum); //해당 위치의 숫자와, 그 숫자를 더했을때 어떤값이 더큰지 체크한다.
            sums[i] = tempMax;
            tempSum = tempMax;
        }

        for (int i = 0; i < n; i++) {
//            System.out.println("sums = " + sums[i]);
            max = Math.max(max, sums[i]);
        }
        bw.write(max+"");

    }


}