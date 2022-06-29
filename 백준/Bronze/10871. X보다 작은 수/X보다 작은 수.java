import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int number = Integer.parseInt(st.nextToken());
    int criteria = Integer.parseInt(st.nextToken());

    String[] arr = br.readLine().split(" ");
    for(int i=0;i<arr.length;i++)
    {
      if(criteria>Integer.parseInt(arr[i]))
      {
        bw.write(arr[i]+" ");
      }
    }
  
    bw.flush();
    bw.close();

    
  }


}