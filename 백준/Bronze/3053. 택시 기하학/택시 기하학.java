import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int r = Integer.parseInt(br.readLine());

    bw.write(String.format("%.6f", r*r*Math.PI)+"\n");
    bw.write(String.format("%.6f", 2.0*r*r)+"\n");

    
    
    bw.flush();
    bw.close();

    
  }


}