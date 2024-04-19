class Solution {
    public int solution(int a, int b, int n) {
        int empty =n;
        int result =0;
        
        while(empty>=a){
            
            
            int rest = empty%a;
            int va = empty/a;
            result += va*b;

            empty = va*b + rest;
            
            

        }
        return result;
        
        
        
    }
}