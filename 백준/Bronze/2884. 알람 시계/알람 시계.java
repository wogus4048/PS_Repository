import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arr = br.readLine().split(" ");


    int clock = Integer.parseInt(arr[0]);
    int minute = Integer.parseInt(arr[1]);


    if(minute < 45)
    {
      if(clock != 0)
      {
        clock -= 1;
      }
      else
      {
        clock = 23;
      }
      minute = 60 - (45-minute);

    }
    else
    {
      minute = minute - 45;
    }

    bw.write(clock+" "+minute);
    bw.flush();
    bw.close();

  }
}