import java.util.*;

public class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

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