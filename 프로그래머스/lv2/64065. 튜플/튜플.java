import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] array = s.split("},");
        
        for(int i=0;i<array.length;i++)
        {
            array[i] = array[i].replaceAll("[{}]","");
        }
        
        Arrays.sort(array,new Comparator<String> ()
                    {
                        @Override
                        public int compare(String s1,String s2)
                        {
                            return s1.length() - s2.length();
                        }
                    });
        
        Map<Integer,String> result = new HashMap<>();

        
        for(int i=0;i < array.length;i++)
        {
            String[] tempArray = array[i].split(",");
            for(int j=0;j<tempArray.length;j++)
            {
                if(!result.containsValue(tempArray[j]))
                {
                    result.put(i+1,tempArray[j]);
                }
            }
        }

        answer = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            answer[i] = Integer.parseInt(result.get(i+1));
        }
        
        
        return answer;
    }
}

//첫번째꺼를 봐서 첫번째수 알수있고
//원소의 수가 2인 집합을 봐서 2번째 수를 알수있고 (이미있는 숫자인지 체크하면됨)
//