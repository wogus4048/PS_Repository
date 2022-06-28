// import java.io.OutputStreamWriter;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
  public static void main(String[] args)  {
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    
    String[][] arr = new String[number][number];
    
    for(int i=0;i<number;i++)
    {
      Arrays.fill(arr[i],"*");
    }

    for(int i=0;i<number;i++)
    {
      for(int j=0;j<number-i-1;j++)
      {
        arr[i][j] = " ";
      }
    }
    print(arr,number);

    sc.close();


    // bw.flush();
    // bw.close();

  }
  static void print(String[][] arr,int number)
  {
    for(int i=0;i<number;i++)
    {
      for(int j=0;j<number;j++)
      {
        System.out.printf(arr[i][j]);
      }
      System.out.println();
    }
  }
}