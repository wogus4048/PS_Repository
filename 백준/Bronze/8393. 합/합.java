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

    int number = Integer.parseInt(br.readLine());
    int sum = 0;
    for(int i=1;i<=number;i++)
    {
      sum +=i;
    }
    bw.write(sum+"\n");
  
    bw.flush();
    bw.close();

    
  }


}