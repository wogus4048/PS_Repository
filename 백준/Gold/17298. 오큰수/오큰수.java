import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    스택 2개를 이용한다.
    스택1에는 숫자들을 저장하고, 스택1에서 하나씩 pop한다. 첫번째인경우는 -1를 출력하고 스택2에 저장한다.
    그다음 다시 스택1에서 pop하고 스택2에서 peek를 해서 스택1에서 pop한 숫자보다 스택2에서 peek한 숫자가 작으면 스택2에서 pop을 해준다.
    그렇게 그 값보다 큰 값을 찾았다면 그값을 출력해주고 또 넘어간다.
    이렇게 하게되면 진행방향은 오른쪽에서 왼쪽이고, 예를들어 3,5,2,7 일때
    7은 -1출력후 스택2로 저장
    2는 스택2에서 peek한 7보다 작으므로 7출력하고 스택2에 저장 -> 현재 스택2 [7,2
    5는 스택2에서 peek한 2보다 크므로 스택2에서 pop해준다 -> 혀냊 스택2 [7  -> 2는 5보다 작으므로 더이상 다른수의 오큰수가 될수없으므로 빼준다(연산횟수를 줄이기위함)
    그리고 다시 스택2에서 peek한 7은 자신보다 크므로 7을 출력하고 다음으로 넘어간다 (만약 peek할 데이터가 없다면 해당 숫자는 오큰수가 없는것이므로 -1 출력)
    를 반복한다.
     */
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int n;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int number : input) {
            stack1.add(number);
        }

    }

    static void solve() throws IOException {
        List<Integer> result = new ArrayList<>();

        //맨오른쪽 숫자는 오큰수가 없으므로 -1 출력 및 스택2에 저장 [스택2에는 오큰수가 될수있는 재료들 저장하는곳]
        result.add(-1);
        stack2.add(stack1.pop());

        //수열을 저장한 스택1이 빌때까지 반복(수열의 모든요소의 오큰수를 출력해야하니까)
        while (!stack1.isEmpty()) {
            int currentNumber = stack1.pop();
            int stack2Size = stack2.size();

            for (int i = stack2Size-1; i >= 0; i--) {
                if (currentNumber < stack2.get(i)) {
                    result.add(stack2.get(i));
//                    sb.append(stack2.get(i)).append(" ");
                    stack2.add(currentNumber);
                    break;
                } else {
                    stack2.pop();
                }
            }
            if (stack2.isEmpty()) {
                result.add(-1);
                stack2.add(currentNumber);
            }
        }

        for (int a = n - 1; a >= 0; a--) {
            bw.write(result.get(a) +" ");
        }

    }

}