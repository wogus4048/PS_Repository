import java.util.*;

class Solution {
    public String solution(String n) {
    
        
//         int length = phone_number.length();

//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < length - 4; i++) {
//             sb.append("*");
//         }
//         sb.append(phone_number.substring(length - 4, length));
        
//         return sb.toString();
        
        
        return "*".repeat(n.length()-4).concat(n.substring(n.length()-4));
        
    }   
}