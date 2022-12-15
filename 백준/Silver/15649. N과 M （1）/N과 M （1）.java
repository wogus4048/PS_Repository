import java.io.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    /**
     * 예제를 보면 순열의 에제와 같다는것을 알 수 있다.
     * 순열은 조합과 다르게 반복문 시작인덱스를 매개변수로 보내지않아도되고, 0으로 반복문을 시작하면 된다 (반복문 시작 인덱스가 0 이라는것은 ,순서가 다르게도 뽑겠다는뜻)
     * 조합과 다르게 visited 방문배열로 뽑은값을 출력하면 안된다 -> 1과 2가 visited에서 true라고 했어도 이게 (1,2)도 이렇게 나타나고 (2,1)도 이렇게 표현되므로
     * 즉 visited 배열 반복문 순회로 뽑힌것을 출력하면 (1,2)와 (2,1)이 구분이 안되기 때문이다.
     *
     * 순열이 동작할때 필요한 매개변수들 -> int n, int r, 뽑을 리스트, 중복방지 방문배열, 뽑은결과 저장할배열, 결과저장할때 인덱스로 쓰고 다 뽑았는지 체크하기위한 depth변수
     * 즉 int n, int r, int[] arr ,boolean[] visited,int[] result , int depth 정도이다.
     * 여기서 int n , int r, int[] arr, boolean[] visited 정도는 static 전역변수로 빼놔도 된다.
     */
    static boolean[] visited;
    static int[] result;
    static int n;
    static int r;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        visited = new boolean[n];
        result = new int[r];

        permutation(result,0);

        bw.flush();
        bw.close();

    }

    public static void permutation(int[] result,int depth) throws IOException{
        if (depth == r) {
            for (int i = 0; i < r; i++) { //뽑은것들 출력
                bw.write(result[i]+" ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; //방문배열 뽑았다고 체크
                result[depth]= i+1; //결과 저장에 해당 값 저장
                permutation(result,depth+1); //depth 증가시키며 재귀실행
                visited[i] = false; // 방문배열 안뽑았다고 수정
            }
        }

    }


}