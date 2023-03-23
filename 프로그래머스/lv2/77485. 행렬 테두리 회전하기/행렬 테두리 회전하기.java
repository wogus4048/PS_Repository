import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        
        int count = 1;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                map[i][j] = count++;
            }
        }
        // System.out.println(Arrays.deepToString(map));
        for(int i=0;i<queries.length;i++)
        {
            // System.out.println("dd");
            int k = getNumber(map,queries[i]);
             // System.out.println("k:"+k);
            answer[i] = k;
        }

        
        return answer;
    }
    public void turnMap(int[][] map,int x,int y, int temp,int x1,int y1,int x2,int y2)
    {
        //제자리면 정지
        if(x == x1 && y == y1)
        {
            // System.out.println(Arrays.deepToString(map));
            return;
        }
        
        int insertNum = temp;
        // System.out.println("x = "+x+"y ="+y+"->"+map[x][y]);
        //맨 윗줄 
        if(x == x1) 
        {
            //가운데 우측이동
            if(y != y1 && y!= y2)
            {
                temp =  map[x][y+1];
                map[x][y+1] = insertNum;
                turnMap(map,x,y+1,temp,x1,y1,x2,y2);
            }
            //맨윗줄오른쪽끝
            if(y == y2)
            {
                temp = map[x+1][y];
                map[x+1][y] = insertNum;
                turnMap(map,x+1,y,temp,x1,y1,x2,y2);
            }
        }
        //중간
        if(x != x1 && x!= x2)
        {
            //오른쪽끝
            if(y == y2)
            {
                temp = map[x+1][y];
                map[x+1][y] = insertNum;
                turnMap(map,x+1,y,temp,x1,y1,x2,y2);
            }
            //왼쪽끝
            if(y == y1)
            {
                temp = map[x-1][y];
                map[x-1][y] = insertNum;
                turnMap(map,x-1,y,temp,x1,y1,x2,y2);
            }
        
        }
        
        //맨 아랫줄 
        if(x == x2) 
        {
            //맨아랫줄 오른쪽끝
            if(y == y2)
            {
                temp = map[x][y-1];
                map[x][y-1] = insertNum;
                turnMap(map,x,y-1,temp,x1,y1,x2,y2);
            }
            
            
            //가운데 좌측이동
            if(y != y1 && y!= y2)
            {
                temp =  map[x][y-1];
                map[x][y-1] = insertNum;
                turnMap(map,x,y-1,temp,x1,y1,x2,y2);
            }
            //맨아랫줄 왼쪽끝
            if(y == y1)
            {
                temp = map[x-1][y];
                map[x-1][y] = insertNum;
                turnMap(map,x-1,y,temp,x1,y1,x2,y2);
            }
        }
        
    }
    
    public int getNumber(int[][] map,int[] query)
    {
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        
        int x2 = query[2]-1;
        int y2 = query[3]-1;
            
        int temp = map[x1][y1+1]; 
        map[x1][y1+1] = map[x1][y1];
        turnMap(map,x1,y1+1,temp,x1,y1,x2,y2);
        
        
        
        
        

        int min = 10001;
        for(int i=x1;i<=x2;i++)
        {
            for(int j=y1;j<=y2;j++)
            {
                // System.out.println("i = "+i+"j ="+j+"->"+map[i][j]);
                if( (i != x1 && i != x2) && (j != y1 && j != y2))
                {
                      continue; 
                }
                else{
                    min = Math.min(min,map[i][j]);
        
                }
            }
        }
        
        return min;
        
    }
}

/*
2,2  5,4  

2,2 2,3, 2,4
3,2 3,4
4,2 4,4
5,2 5,3 5,4

2 ~ 5 행까지 반복
첫번째 행(2) 마지막행(5)는  첫번째열+1 (2+1) ~ 마지막열-1(4-1) 까지 포함한다.

각 회전별 가장 작은숫자를 구해 배열에 담는다.
*/