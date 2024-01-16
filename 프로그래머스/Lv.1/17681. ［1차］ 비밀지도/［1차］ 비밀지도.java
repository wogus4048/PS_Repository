import java.util.*;
import java.math.*;

class Solution {
    static String[][] map1;
    static String[][] map2;
    static String[] answer;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        map1 = new String[n][n];
        map2 = new String[n][n];
        answer = new String[n];
        mapChange(n,arr1,map1);
        mapChange(n,arr2,map2);
        mapAdd(n);
        // System.out.println(Arrays.deepToString(map1));
        
        return answer;
    }
    
    void mapChange(int n, int[] arr, String[][] map)
    {
        for(int i=0;i<n;i++)
        {
            int currentNum = arr[i];
            int count =0;
            for(int j=n-1;j>=0;j--)
            {
                int pow = (int)Math.pow(2,j);
                if(currentNum / pow >=1)
                {
                    map[i][count] = "#";
                    currentNum = currentNum % pow;
                }
                else{
                    map[i][count] = "";
                }
                
                count++;
            }
        }
        
    }
    
    void mapAdd(int n)
    {
        for(int i=0;i<n;i++)
        {
            StringBuilder sb = new StringBuilder();
            
            for(int j=0;j<n;j++)
            {
                if(map1[i][j].equals("#") || map2[i][j].equals("#"))
                {
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }

            }
            answer[i] = sb.toString();
        }
        
    }
        
    
    
}