import java.util.*;

class Solution {
    public static String solution(String number, int k) {

        List<Character> list = new ArrayList<>();
        for(int i=0;i<number.length();i++)
        {
            list.add(number.charAt(i));
        }

        for(int i=0;i<number.length();i++)
        {
            if(k ==0)
            {
                break;
            }
            if(i == number.length() -1)
            {
                list.set(i,'A');
                break;
            }

            char current = list.get(i);
            int currentValue = Character.getNumericValue(current);
            if(currentValue == 9)
            {
                continue;
            }
            int max = i+1+k;
            for(int j=i+1;j < max; j++)
            {
                if(j >= number.length())
                {
                    break;
                }

                int nextValue = Character.getNumericValue(list.get(j));
                if(currentValue < nextValue)
                {
                    list.set(i,'A');
                    k--;
                    break;
                }
            }

        }

        StringBuilder answer = new StringBuilder();
        for(char a : list)
        {
            if(a != 'A')
            {
                answer.append(a);
            }

        }
        return answer.toString();


    }
}

/*
자신의 위치에서 k번 뒤로갔는데도 자신이 가장 크다면 지우지않아도되고
아니라면 자신을 지우고 k--;
*/