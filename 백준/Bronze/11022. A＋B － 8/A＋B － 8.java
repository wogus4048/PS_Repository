import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test_case = Integer.parseInt(br.readLine());
    String[][]arr = new String[test_case][2];
    for(int i=0;i<test_case;i++)
    {
      arr[i] = br.readLine().split(" ");
    }


    for(int i=0;i<test_case;i++)
    {

      int result = Integer.parseInt(arr[i][0])+Integer.parseInt(arr[i][1]);

      System.out.println(String.format("Case #%d: %s + %s = %d",i+1,arr[i][0],arr[i][1],result ));

    }

  
    bw.flush();
    bw.close();

    
  }


}