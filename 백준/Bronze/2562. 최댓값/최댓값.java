import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr= new int[9];

    for(int i=0;i<9;i++)
    {
      int temp2  =Integer.parseInt(br.readLine());
      arr[i] = temp2;
    }

    int max=0;
    int index =0;

    for(int i=0;i<9;i++)
    {

      if(arr[i] > max)
      {
        max =arr[i];
        index =i+1;
      }

    }
    bw.write(max+"\n");
    bw.write(index+"\n");

    


    
  

      
      
    bw.flush();
    bw.close();
    
  }


    
  }


