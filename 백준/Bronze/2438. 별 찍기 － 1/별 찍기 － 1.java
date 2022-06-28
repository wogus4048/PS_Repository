import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int number = Integer.parseInt(br.readLine());
    
    for (int i=1;i<=number;i++)
    {
      for (int j=0; j<i;j++)
      {
        bw.write("*");
      }
      bw.write("\n");
    }




    bw.flush();
    bw.close();

  }
}