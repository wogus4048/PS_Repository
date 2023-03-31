import java.util.*;

class Solution {
    
    static Set<Integer> s = new HashSet<>();
    static int count =0;
    
    public int solution(String numbers) {
        
        for(int i=1;i<=numbers.length();i++)
        {
            int n = numbers.length();
            boolean[] visited = new boolean[n];
            permutation(numbers,n,i,visited,0,new int[i]);
        }
        
        // System.out.println(s.toString());
        if(s.contains(0))
        {
            s.remove(0);
        }
        if(s.contains(1))
        {
            s.remove(1);
        }
        
        Iterator iter = s.iterator();
        while(iter.hasNext())
        {
            int number = (int)iter.next();
            boolean check = true;
            for(int i=2;i<number-1;i++)
            {
                if(number % i == 0)
                {
                    check = false;
                    break;
                }
            }
            if(check)
            {
                count ++;
            }
        }
        
    
        
        return count;
    }
    
    static void permutation(String array,int n, int r, boolean[] visited, int depth, int[] result)
        {
            if(r == depth)
            {
                String temp ="";
                for(int i=0;i<depth;i++)
                {
                    temp += result[i];
                }
                s.add(Integer.parseInt(temp)); 
                
                return;
        
            }
            for(int i=0;i<n;i++)
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    result[depth] = (int)array.charAt(i) -'0';
                    permutation(array,n,r,visited,depth+1,result);
                    visited[i] = false;
                }
            }
            
        }
}
/*
1 또는 자기자신으로만 나눠져야함, 즉 약수가 자기자신인지 체크
n이 있다면 2부터 n-1까지 나눠본다.
1은 제외

순열을 돈다. 
나온 결과를 Set에 저장..

Set에 저장된것을 하나씩 소수인지 체크..

소수면 정답에 추가..
*/