import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int number = Integer.parseInt(br.readLine());
    int line = (number * 2) -1;
    int star_number = 1;

    for(int i =1;i<=line;i++)
    {
      
      if(i <= number)
      {
        for(int j=number-i;j>0;j--)
        {
          bw.write(" ");
        }
        for(int j=0;j<star_number;j++)
        {
          bw.write("*");
        }
        if(star_number<line)
        {
          star_number += 2;
        }
        bw.write("\n");
        
      }
      else if(i >number)
      {
        star_number -= 2;
        for(int j=0;j<i-number;j++)
        {
          bw.write(" ");
        }
        for(int j=0;j<star_number;j++)
        {
          bw.write("*");
        }
        bw.write("\n");        


      }

      

    }





    bw.flush();
    bw.close();

    
  }


}