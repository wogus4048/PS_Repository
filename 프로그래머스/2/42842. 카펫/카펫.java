class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int width;
        int height;
        int area = brown + yellow;
        
        for(int i=3;i<area;i++)
        {
            for(int j=3;j<area;j++)
            {
                if(i*j > area) break;
                if(i*j == area) {
                    if( (j-2) * (i-2) == yellow) return new int[]{j,i};
                }
            }
        }
        
        
        
        
        return answer;
    }
}