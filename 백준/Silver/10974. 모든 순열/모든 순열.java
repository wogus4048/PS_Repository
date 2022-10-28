
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine()); //입력받은수
        int[] arr = new int[number]; // 1 ~ 입력받은 수까지를 요소로 가지는 배열
        for(int i=1;i<=number;i++)
        {
            arr[i-1] = i; //1 ~ 입력받은 수까지를 요소로 가지는 배열
        }
        boolean[] visited = new boolean[number]; //방문배열
        int[] result = new int[number]; //결과를 저장할 배열 , 순열은 순서가 중요하므로 순서대로 저장하기위해 담을곳이 필요.

        permutation(arr,visited,0,result);

        bw.flush();
        bw.close();




    }
    static void permutation(int[] arr ,boolean[] visited,int count,int[] result  ) throws IOException
    {
        if(count == arr.length) //다 뽑았다면
        {
            for(int i=0;i<result.length;i++)
            {
                bw.write(result[i]+" ");
            }
            bw.newLine();
            return;
        }

        //뽑을 재료들을 전부 돌면서 깊이우선탐색한다 -> 깊이우선탐색으로 인해 결과는 사전순으로(3,1,2 -> 3,2,1)나온다.
        for(int i=0;i<arr.length;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                result[count] = arr[i];
                permutation(arr,visited,count+1,result);
                visited[i] = false;

            }
        }


    }


}
