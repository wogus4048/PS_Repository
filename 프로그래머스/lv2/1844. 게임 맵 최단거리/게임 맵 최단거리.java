import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int n,m;
    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};
    static int result = 0;
    
    public int solution(int[][] maps) {
        /*
        bfs 최소 이동거리 문제
        */
        n = maps.length;
        m = maps[0].length;
        
        
        visited = new boolean[n][m];

        bfs(maps);
        if(result == 0)
        {
            return -1;
        }
        else{
            return result+1;
        }

    }
    
    static void bfs(int[][] maps)
    {
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,0}); //i , j , step
        visited[0][0] = true;
        
        while(!q.isEmpty())
        {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];
            int currentStep = current[2];
            
            if(currentI == n-1 && currentJ == m-1)
            {
                result = currentStep;
                break;
            }
            
            for(int i=0;i<4;i++)
            {
                int nextI = currentI + di[i];
                int nextJ = currentJ + dj[i];
                
                if(nextI >=0 && nextI <n && nextJ >=0 && nextJ <m)
                {
                    if(!visited[nextI][nextJ] && maps[nextI][nextJ] == 1)
                    {
                        visited[nextI][nextJ]= true;
                        q.add(new int[]{nextI,nextJ,currentStep+1});
                    }
                }
                
            }
            
            
        }
        
    
    }
}