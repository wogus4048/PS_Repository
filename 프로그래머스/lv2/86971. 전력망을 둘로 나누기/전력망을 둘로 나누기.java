import java.util.*;

class Solution {
    static boolean[] visited;
   
    static List<List<Integer>> graph;
    static int count=0;
    
    public int solution(int n, int[][] wires) {
        int answer =1000000;
        for(int i=0;i<wires.length;i++)
        {
            graph = new ArrayList<>(); //인접리스트 생성
            for(int a=0;a<n+1;a++)
            {
                graph.add(new ArrayList<Integer>());
            }
            for(int j=0;j<wires.length;j++) //한개씩 전선을 잘라보며 인접리스트 생성
            {
                if( i == j) //
                {
                    continue;
                }
                int start = wires[j][0];
                int end = wires[j][1];
                
                graph.get(start).add(end); //양방향
                graph.get(end).add(start);
                
            }
            
            //인접리스트를 이용해서
            //dfs를 돌면서 두 노드사이클의 각 노드의 수를 구함. 절대값의 차를 구함.
            
            visited = new boolean[n+1];
            List<Integer> answerList = new ArrayList<>();
            
            for(int b=1;b<=n;b++)
            {
                if(!visited[b])
                {
                    dfs(b);
                    answerList.add(count);
                    count =0;
                }
            }
            answer = Math.min(answer,Math.abs(answerList.get(0)-answerList.get(1)));
            
  
        }
        
        return answer;
    }
    
    void dfs(int node)
    {
        visited[node] = true;
        count++;
        
        for(int adjNode : graph.get(node))
        {
            if(!visited[adjNode])
            {
                dfs(adjNode);
            }
        }
    }
}

/*

dfs 를 통해 그룹노드의 노드수를 센다.
한줄씩 끊어보면서 2개의 그룹노드의 차이의 절대값이 가장 작은것을 출력한다.
*/