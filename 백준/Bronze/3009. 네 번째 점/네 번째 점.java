import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] a = br.readLine().split(" ");
    String[] b = br.readLine().split(" ");
    String[] c = br.readLine().split(" ");

    String[] result = new String[2];

    if(a[0].equals(b[0]))
    {
      result[0] = c[0];
    }
    else if(a[0].equals(c[0]))
    {
      result[0] = b[0];
    }
    else
    {
      result[0] = a[0];
    }
    if(a[1].equals(b[1]))
    {
      result[1] = c[1];
    }
    else if(a[1].equals(c[1]))
    {
      result[1] = b[1];
    }
    else
    {
      result[1] = a[1];
    }
    bw.write(result[0]+" "+result[1]);

    bw.flush();
    bw.close();

    
  }


}