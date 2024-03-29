

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int input = Integer.parseInt(br.readLine());

        char[][] result = new char[input][input];


        for(int i=0;i<input;i++)
        {
            for(int j=input-1 ;j>input-2-i; j--)
            {
                result[i][j] = '*';
            }
        }

        for(int i=0;i<input;i++)
        {
            for(int j =0;j<input;j++)
            {
                if(result[i][j] == 0) // 0을 이용해서 비교
                {
                    bw.write(" ");
                }
                else{
                    bw.write(result[i][j]);
                }

            }
            bw.newLine();
        }


        bw.flush();
        bw.close();


    }



}
