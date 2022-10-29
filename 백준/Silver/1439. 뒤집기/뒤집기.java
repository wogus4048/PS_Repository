

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        int result1 = 0;
        int result0 = 0;

        Stack<Integer> list = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            int temp = Character.getNumericValue(input.charAt(i));
            list.push(temp);
        }
//        bw.write(list+"\n");

        int ex = -1;

        while(!list.isEmpty())
        {
            int current = list.pop();
            if(ex != -1)
            {
                if (current == ex) {
                    continue;
                }
            }
            if(current == 0)
            {
                result0++;
                ex = current;
            }
            else {
                result1++;
                ex = current;
            }
        }

        if(result0>result1)
        {
            bw.write(result1+"");
        }
        else{
            bw.write(result0+"");
        }




        bw.flush();
        bw.close();


    }



}
