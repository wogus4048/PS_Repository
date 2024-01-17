import java.util.*;
import java.math.*;
class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0)
        {
            sb.append(n%3);
            n /= 3;
        }
        System.out.println(sb.toString());
        String answer = sb.toString();
        int aa = Integer.parseInt(answer,3);
        // System.out.println(aa+"dddd");
        // int ans = 0;
        // int aa = Integer.parseInt(answer,3);
        
//         for(int i=0;i<answer.length();i++)
//         {
//             if(answer.charAt(i)=='0')
//             {
//                 continue;
//             }
//             int cNum = Character.getNumericValue(answer.charAt(i));
//             int pNum = answer.length() - i -1;
//             System.out.println(cNum + " " + pNum +" "+ Math.pow(3,pNum)+" "+cNum * (int)Math.pow(3,pNum));
            
//             ans += cNum * (int)Math.pow(3,pNum);
//         }
        
        return aa;
    }
}