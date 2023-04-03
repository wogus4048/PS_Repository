import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount =0;
        Deque<Integer> peopleDeq = new LinkedList<>();
        for(int p : people)
        {
            peopleDeq.add(p);
        }

        while(!peopleDeq.isEmpty())
        {
            Integer fatPerson = peopleDeq.peekLast();
            boatCount++;
            
            if( peopleDeq.size() >= 2 && (fatPerson + peopleDeq.peek()) <= limit)
            {
                peopleDeq.pollLast();
                peopleDeq.pollFirst();
            }
            else{
                peopleDeq.pollLast();
            }

        }

        return boatCount;

    }
}