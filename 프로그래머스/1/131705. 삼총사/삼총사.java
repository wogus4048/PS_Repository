class Solution {
    
    static int answer =0;
    public int solution(int[] number) {
        int n = number.length;
        int[] result = new int[n];
        
        combi(number,n,0,0,result);
        
        return answer;
    }
    
    public void combi(int[] number, int n, int index,int depth,int[] result)
    {
        if(depth == 3)
        {
            int temp =0;
            for(int cNum :result )
            {
                temp+= cNum;
            }
            if(temp == 0)
            {
                answer++;
            }
            return;
        }
        
        for(int i=index;i<n;i++)
        {
            result[depth] = number[i];
            combi(number,n,i+1,depth+1,result);
        }
        
        
    }
}