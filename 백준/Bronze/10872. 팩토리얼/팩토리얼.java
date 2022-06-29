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

    bw.write(fac(number)+"\n");

      
      
    bw.flush();
    bw.close();
    
  }

  static int fac(int num)
  {
    if(num == 0 | num ==1)
    { 
      return 1;
    }
    return num * fac(num-1);
  }
    
  }


