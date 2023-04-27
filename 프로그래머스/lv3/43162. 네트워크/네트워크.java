import java.util.*;

class Solution {
    /*
        dfs 도는 bfs가 몇번 동작하는지 체크하는 문제 -> 백준의 촌수구하는 문제
        인접배열 -> 인접리스트로 변환 
    */
    
    static List<Integer>[] graph;
    
    static boolean[] visited;
    
    static int count =0;
    
    public int solution(int n, int[][] computers) {
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int a=1;a<n+1;a++)
        {
            graph[a] = new ArrayList<>(); // 그래프 초기화
        }
        
        //인접리스트를 이용하여 그래프 생성
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j) // 그래프에는 인접노드만 
                {
                    continue;
                }
                if(computers[i][j] == 1)
                {
                    graph[i+1].add(j+1);
                }
                
            }
        }
        
        for(int i=1;i<=n;i++)
        {
            if(!visited[i])
            {
                dfs(i);
                count++;
            }
            // System.out.println(graph[i].toString());
        }
        
        
        
        
        return count;

        
    }
    
    static void dfs(int node)
    {

        for(int adjNode : graph[node])
        {
            if(!visited[adjNode])
            {
                visited[adjNode] = true;
                dfs(adjNode);
            }
        }

    }
}