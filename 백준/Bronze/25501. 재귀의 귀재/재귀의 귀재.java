import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int[] getResult = isPalindrome(input);
            bw.write(getResult[0]+ " "+getResult[1]+"\n");
        }
        
        bw.flush();
        bw.close();

    }
    public static int[] recursion(String s, int l, int r,int[] result){
        if(l >= r) {
            result[0] = 1;
            return result;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            result[0] = 0;
            return result;
        }
        else {
            result[1] += 1;
            return recursion(s, l+1, r-1,result);
        }

    }
    public static int[] isPalindrome(String s){
        int[] result = new int[2];
        result[1] = 1;
        return recursion(s, 0, s.length()-1,result);
    }


}