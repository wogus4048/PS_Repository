class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        permutation(dungeons.length,visited,0,k,dungeons);
        return answer;
        
        // for(int i=dungeons.length; i>1 ;i--)
        // {
        //     boolean[] visited = new boolean[dungeons.length];
        //     permutation(dungeons.length,i,visited,0,k,dungeons);
        //     if(answer!= -1)
        //     {
        //         return answer;
        //     }
        // }
        
//         for(int i=0;i<dungeons.length;i++)
//         {
//             if(dungeons[i][0] <= k)
//             {
//                 return 1;
//             }
//         }
//         return 0;
        
    }
        void permutation(int n, boolean[] visited, int depth,int k,int[][] dungeons )
    {
        answer = Math.max(answer,depth);
        
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                //방문전 갈수있는지 체크 
                if(dungeons[i][0] > k)
                {
                    continue;
                }
            
                visited[i] = true;
                permutation(n,visited,depth+1,k-dungeons[i][1],dungeons);
                visited[i] = false;
            }
        }
    }
    
    
    
//     void permutation(int n, int r, boolean[] visited, int depth,int k,int[][] dungeons )
//     {
        
//         if(depth == r)
//         {
//             answer = r;
//             return;
//         }
        
//         for(int i=0;i<n;i++)
//         {
//             if(!visited[i])
//             {
//                 //방문전 갈수있는지 체크 
//                 if(dungeons[i][0] > k)
//                 {
//                     continue;
//                 }
            
//                 visited[i] = true;
//                 permutation(n,r,visited,depth+1,k-dungeons[i][1],dungeons);
//                 visited[i] = false;
//             }
//         }
//     }
    
}


/*
순열
r => 던전 갯수인 탐험할수있는 최대던전수부터 체크
반복문으로 순열동작
r이 최소 2까지 동작하고

한개 돌수있는지는 반복문으로 체크
있으면 1 없으면 0
*/