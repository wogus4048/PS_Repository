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



    for(int i=0;i<test_case;i++)
    {
      String[] arr = br.readLine().split(" ");
      int result = Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
      System.out.println(String.format("Case #%d: %s + %s = %d",i+1,arr[0],arr[1],result ));

    }

  
    bw.flush();
    bw.close();

    
  }


}