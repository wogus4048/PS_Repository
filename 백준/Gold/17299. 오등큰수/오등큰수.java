import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
     */
    static Map<Integer, Integer> map = new HashMap<>();

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int n;
    static int[] input;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int number : input) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            stack1.add(number);
        }

    }

    static void solve() throws IOException {
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });

        List<Integer> result = new ArrayList<>();
        //맨 오른쪽 숫자는 -1이니까
        result.add(-1);
        stack2.add(stack1.pop());

        while (!stack1.isEmpty()) {
            int currentNumber = stack1.pop();
            int currentStack2Size = stack2.size();
            for (int i = 0; i < currentStack2Size; i++) {
                if (map.get(currentNumber) < map.get(stack2.peek())) {
                    result.add(stack2.peek());
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

        for (int i = n - 1; i >= 0; i--) {
            bw.write(result.get(i)+" ");
        }

    }

}