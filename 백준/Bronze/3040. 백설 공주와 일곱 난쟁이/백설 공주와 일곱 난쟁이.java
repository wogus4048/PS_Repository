import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Main{
  static int target = 0; // 전역변수로 선언.
  static ArrayList<String> result = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> al = new ArrayList<>();

    String input;
    

    int sum =0; // 난쟁이 모자 숫자 총합.

    while((input = bf.readLine()) != null)
    { 
      al.add(input); // 리스트에 각각의 난쟁이 모자 숫자 넣어줌.
      sum += Integer.parseInt(input); // 난쟁이 모자 숫자를 더해줌.

    }
    boolean[] visited = new boolean[al.size()];

    //난쟁이 모자 숫자를 모두 더한값에서 100을 빼준값을 저장한다.
   // 9명의 난쟁이 모자에서 2명을 뽑아 합해서 빼준값이 나오는것을 검사한다.
    target = sum - 100 ;

    String[] arr = al.toArray(new String[0]); 
     // 리스트를 배열로 전환
    combination(arr, visited, 0, 2);

    for (int i=0;i<result.size();i++)
    {
      System.out.println(result.get(i));
      
    }
    
    

	}
  static void combination(String[] arr, boolean[] visited, int start, int r) 
  {
    if (r == 0) 
    {
      int temp =0;
      for(int i=0;i<arr.length;i++)
      {
        if (visited[i] == true) 
        {
            temp += Integer.parseInt(arr[i]);
        }
      }
      if(temp == target)
      {
        for(int i=0; i<arr.length;i++)
        {
          if (visited[i] == false) 
        {
          result.add(arr[i]);
        }
        }
        // print(arr, visited);
      }

      return;
    }

    for (int i = start; i < arr.length; i++) 
    {
        visited[i] = true;
        combination(arr, visited, i + 1, r - 1);
        visited[i] = false;
    }
  }


  static void print(String[] arr, boolean[] visited)
  {
    for (int i = 0; i < arr.length; i++) 
    {
        if (visited[i] == true) 
        {
            System.out.print(arr[i] + " ");
        }
    }
    System.out.println();
  }

  
    


	
  


	
    
}


    


  