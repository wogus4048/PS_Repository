import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        int round=0;
        int failNum=0;
        char lastW = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        
        for(int i=1;i<words.length;i++)
        {
            char cfirstW = words[i].charAt(0);
            if( cfirstW != lastW || set.contains(words[i])){
                round = (i/n) +1;
                failNum = (i%n) +1;
                break;
            }
            set.add(words[i]);
            lastW = words[i].charAt(words[i].length()-1);

        }


        return new int[]{failNum,round};
    }
}