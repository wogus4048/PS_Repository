import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        List<Integer> prior = new ArrayList<>();
        List<Integer> loca = new ArrayList<>();

        
        for(int i =0 ;i<priorities.length;i++ )
        {
            prior.add(priorities[i]);
            loca.add(i);
        }
        // System.out.println(prior.toString());
        // System.out.println(loca.toString());

        boolean check = true;
        
        while(!prior.isEmpty())
        {
            int firstPrior = prior.get(0);
            int firstLoca = loca.get(0);
            // System.out.println("firstPrior : "+ firstPrior);
            // System.out.println("pri : "+ prior.toString());
            for(int i=1;i<prior.size();i++)
            {
                if(firstPrior<prior.get(i))
                {
                    prior.remove(0);
                    prior.add(firstPrior);
                    loca.remove(0);
                    loca.add(firstLoca);
                    check = false;
                    break;
                }
            }
            // System.out.println("pri2 : "+ prior.toString());
            // System.out.println("loca2 : "+loca.toString());
   
            if(check)  //맨앞에 있는게 제일큰거면
            {   
                if(firstLoca == location) //찾던거면
                {
                    return answer+1;
                }
                //아니면
                prior.remove(0);
                loca.remove(0);
                answer++;
            }
            check = true;
  
        }

        return answer;
    }
}

/*
1. 리스트를 사용
맨뒤나 맨앞에  값을 넣고 삭제는 시간복잡도 1
나머지 인덱스에 값을 넣고 삭제는 시간복잡도 n
문서갯수가 100이므로 n^2도 가능
*/