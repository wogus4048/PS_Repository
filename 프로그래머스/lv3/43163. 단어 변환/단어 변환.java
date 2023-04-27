import java.util.*;

class Solution {
    static boolean[] visited;
    static int n;
    static int result =0;
    
    public int solution(String begin, String target, String[] words) {
        /*
        문자의 차이가 1개인 단어를 찾아서 bfs진행
        */
        
        n = words.length;
        visited = new boolean[n];
        
        bfs(target,words,begin);
      
        return result;
        

    }
    
//     static void dfs(String target, String[] words, String current, int step)
//     {

//         if(current.equals(target))
//         {
//             result= Math.min(result,step);
//             return;
//         }
        
//         for(int i=0;i<n;i++)
//         {
//             if(!visited[i])
//             {
//                 String compareString = words[i];

//                 if(checkString(current,compareString))
//                 {
//                     System.out.println(compareString);
//                     visited[i] = true;
//                     dfs(target,words,compareString,step+1);
//                     visited[i] = false;
//                 }
//             }
//         }
        
        
//     }
    
    static void bfs(String target, String[] words, String current)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(current,0));    
        
        while(!q.isEmpty())
        {
            Node currentNode = q.poll();
            String c = currentNode.word;
            int currentStep = currentNode.step;
            
            if(c.equals(target))
            {
                result = currentStep;
                return;
            }
            
            for(int i=0;i<n;i++)
            {
                if(!visited[i])
                {
                    String compareString = words[i];

                    if(checkString(c,compareString))
                    {
                        // System.out.println(compareString);
                        visited[i] = true;
                        q.add(new Node(compareString,currentStep+1));
                    }
                }
            }
            
            
        }
    }
    
    static boolean checkString(String current, String compare)
    {
        int length = current.length();
        int count =0;
        
        char[] c1 = current.toCharArray();
        char[] c2 = compare.toCharArray();
        
        for(int i=0;i<length;i++)
        {
            if(c1[i] == c2[i])
            {
                count ++;
            }

        }
        
        if(count == length -1)
        {
            return true;
        }

        return false;
        
    }
    
    static class Node{
        String word;
        int step;
        
        public Node(String word,int step)
        {
            this.word = word;
            this.step = step;
        }
    }
    
    
    
}