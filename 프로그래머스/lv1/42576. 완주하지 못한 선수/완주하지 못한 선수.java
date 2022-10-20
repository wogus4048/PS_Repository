import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> par = Arrays.asList(participant);
        List<String> com = Arrays.asList(completion);
        
        Collections.sort(par);  // Collections.sort는 최악 nlogn     // Arrays.sort는 최악 n^2  //둘다 통과는됨
        Collections.sort(com);

        for(int i=0;i<participant.length-1;i++)
        {
            if(!participant[i].equals(completion[i]))
            {
                return participant[i];
            }
        }
        answer = participant[participant.length-1];
        


        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant,completion));


    }


}