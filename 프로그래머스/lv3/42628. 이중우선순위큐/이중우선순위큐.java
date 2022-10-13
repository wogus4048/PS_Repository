

import java.util.*;

public class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = {};
        List<Integer> a = new ArrayList<>();

        for(int i=0;i<operations.length;i++)
        {
            StringTokenizer st = new StringTokenizer(operations[i]);

            String operation = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            if(operation.equals("I"))
            {
                a.add(number);
            }
            else{
                if(a.isEmpty())
                {
                    continue;
                }
                else{
                    if(number == 1)
                    {
                        a.remove(a.size()-1);
                    }
                    else{
                        a.remove(0);

                    }
                }


            }
            Collections.sort(a);


        }
        if(a.isEmpty())
        {
            return new int[] {0,0};
        }
        else{
            return new int[] {a.get(a.size()-1) , a.get(0)};
        }







    }

    public static void main(String[] args) {
        String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operation)) ) ;
    }


}
