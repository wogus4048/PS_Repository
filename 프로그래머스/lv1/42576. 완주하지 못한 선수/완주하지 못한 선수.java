import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> part = new HashMap<>();
        Map<String,Integer> comp = new HashMap<>();
        
        for(String name : participant)
        {
            part.put(name,part.getOrDefault(name,0)+1);
        }
        for(String name : completion)
        {
            comp.put(name,comp.getOrDefault(name,0)+1);
        }
        // System.out.println(part);
        // System.out.println(comp);
        
        for(Entry<String,Integer> entry : part.entrySet())
            //entrySet을 사용하려면 import java.util.Map.*; 필수 
        {
            String key = entry.getKey();
            int value = entry.getValue();
            if(!comp.containsKey(key))
            {
                return key;
            }
            if(comp.get(key) != value)
            {
                return key;
            }
        }
        
       return "";
    }
}
/*
1.
참가자,완주자 명단을 정렬
참가자명단을 반복문을 돌면서 같은 인덱스에 완주자 명단을 보고 이름이 같은지 체크 아니면 완주 못한사람 
public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        if(participant.length == 1)
        {
            return participant[0];
        }
        
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        // System.out.println(Arrays.toString(participant));
        // System.out.println(Arrays.toString(completion));
        
        for(int i=0; i<completion.length;i++)
        {
            if(!participant[i].equals(completion[i]))
            {
                return participant[i];
            }
        }
        
        return participant[participant.length-1];
    }
2.
Map 2개만들어서 각각 참가자 ,완주자 정리
참가자 Map을 돌면서 해당 키가 존재하는지, 존재하면 value의 값이 같은지 체크 아니면 완주 못한사람 
*/