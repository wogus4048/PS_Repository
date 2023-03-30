class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        
        for(int h=1; h<=length; h++)
        {
            int a = 0; // h번 이상인 논문 갯수
            
            for(int i=0; i<length; i++)
            {
                if(citations[i] >= h)
                {
                    a ++;
                }
            }
            
            if( a >= h && (length-a) <=h) //h번 이상 인용된 논문이 h편이라면 + 나머지가 h번 이하이여야함
            {// h는 여러개 될수있고 가장 큰것을 리턴해야함.
                answer = Math.max(answer,h);
            }
            
        }
        
        if(length ==1 && citations[0] == 0)
        {
            return 0;
        }
        
        
        
        return answer;
    }
}

/*
h 예비 : 1 ~ citations의 길이 


*/