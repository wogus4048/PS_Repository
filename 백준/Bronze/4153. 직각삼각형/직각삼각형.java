import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true)
    {
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int[] arr = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
      Arrays.sort(arr);

      if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
      {
        break;
      }

      String result = (  (Math.pow(arr[0],2) + Math.pow(arr[1],2)) == Math.pow(arr[2],2) ) ? "right":"wrong";
  
      bw.write(result+"\n");

    }
    
    bw.flush();
    bw.close();

    
  }


}