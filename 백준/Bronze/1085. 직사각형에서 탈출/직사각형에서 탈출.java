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
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int temp_x = 0;
    int temp_y = 0;


    if(w-x < x-0 )
    {
      temp_x = w-x;
      if(h -y < y-0)
      {
        temp_y = h-y;
      }
      else
      { 
        temp_y = y-0;
      }

      if(temp_x < temp_y)
      {
        System.out.println(temp_x);
      }
      else  System.out.println(temp_y);


    }
    else
    {
      temp_x = x-0;
      if(h-y < y-0)
      {
        temp_y = h-y;
      }
      else
      {
        temp_y = y-0;
      }

      if(temp_x < temp_y)
      {
        System.out.println(temp_x);
      }
      else  System.out.println(temp_y);


    }
    

    bw.flush();
    bw.close();

    
  }


}