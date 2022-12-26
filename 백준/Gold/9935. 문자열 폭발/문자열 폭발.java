import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
       문자열에서 특정 문자열을 찾아 지우고 다시합친다, 를 반복
       완전탐색은 시간초과가 날것이다.
       큐를 이용해서 ? -> 인덱스를 이용할수없으니 앞에서 뒤로 계속 값을 옮겨야함.
       스택을 이용해서? -> 인덱스를 이용해서 쉽게 비교가능.
       리스트를 이용해서? -> 인덱스때문에 스택을 사용한다면 리스트는? -> Array 리스트의 특정인덱스 삽입, 삭제는 O(n)이지만 맨뒤에 삽입삭제는 O(1)?
       최대 100만 문자열 반복문 * 최대 36길이 폭발문자열 -> 시간초과 x?
     */
    static List<Character> list = new ArrayList<>();
    static char[] input;
    static char[] boom;
    static int boomLength;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        input = br.readLine().toCharArray();
        boom = br.readLine().toCharArray();
        boomLength = boom.length;
    }

    static void solve() throws IOException {

        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
            if (list.size() >= boomLength) {
                boolean check = true;
                for (int j = 0; j < boomLength; j++) {
                    if (list.get(list.size() - boomLength+j) != boom[j]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int k = 0; k < boomLength; k++) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        if (list.isEmpty()) {
            bw.write("FRULA");
        } else {
            for (char a : list) {
                bw.write(a+"");
            }
        }

    }
    
}