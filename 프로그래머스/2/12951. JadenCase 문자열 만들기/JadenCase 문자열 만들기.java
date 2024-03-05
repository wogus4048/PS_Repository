
class Solution {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split(" ");

        for(String ss : str)
        {
            if(ss.length() > 0)
                answer += ss.substring(0,1).toUpperCase() + ss.substring(1).toLowerCase() + " ";
            else
                answer += " ";
        }

        if (s.charAt(s.length() - 1) != ' ')
            answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}