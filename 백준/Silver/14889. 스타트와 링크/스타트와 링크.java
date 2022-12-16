import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * start팀과 link팀이 될 수 있는 모든 경우를 구해야한다.
     * 어떻게 구할까 생각했다. int[] 로 모든 사람들 저장하고 , 한명씩 뽑고, 안뽑고를 진행할까?
     * 결국 조합이므로 조합은 뽑고 안뽑고를 진행할때 필요한 boolean[] 방문배열로 뽑은 결과를 알 수 있으므로 뽑힌사람은  start팀 , 안뽑힌사람은 link팀으로한다.
     * 조합을 돌리며 start팀의 능력치와 link팀의 능력치를 구하고 차이를 구하고 min 값을 구한다.
     */

    static int n;
    static int[][] power; //능력치
    static boolean[] visited; // true인 애들이 start팀 false인 애들이 link팀
    static int min= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        power = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                power[i][j] = Integer.parseInt(input[j]);
            }
        }
        visited = new boolean[n];
    }

    static void solve() throws IOException {
        combination(n,n/2,0,visited);
        bw.write(min+"");
    }

    static void combination(int n ,int r, int start ,boolean[] visited) {
        if (r == 0) {
            calculateTeamPower(visited);
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(n, r - 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }

    static void calculateTeamPower(boolean[] visited) { //각 팀의 능력치를 계산하고 차이도 계산한 후 최소값인지 체크하는 메소드
        int startTeamPower=0;
        int linkTeamPower=0;
        for (int i = 0; i < visited.length; i++) {  // [0][0] ~ [n-1][n-1]의 모든경우를 체크한다, 한사람씩 어디에 속해있는지 , 어떤사람과 팀인지 체크하여
            for (int j = 0; j < visited.length; j++) { // [i][j] [j][i] 의 값을 능력치로 더해준다.
                if (visited[i] && visited[j]) { //i번째 선수가 start팀일때, j번째 선수도 start 팀이라면? 능력치를 더해준다.
                    startTeamPower += power[i][j];
                } else if (!visited[i] && !visited[j]) { //혹은 둘다 link팀이라면
                    linkTeamPower += power[i][j];  // link팀 능력치를 올려준다.
                }
            }
        }
        // [i][j]는 더할때 왜 [j][i]는 안더해주나 -> 어차피 반복문 돌면서 [j][i]도 값이 들어가게 되어있다.

        int gap = Math.abs(startTeamPower - linkTeamPower);
        min = Math.min(min, gap);
    }

}