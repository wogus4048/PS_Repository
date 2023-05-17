import java.util.*;

class Solution {
    static List<Set<Integer>> dp = new ArrayList<>();
    // 숫자의 개수마다 나올수 있는 수들을 저장하는 List
    // set은 contains의 시간복잡도가 1이므로 빠른 서칭가능
    public int solution(int N, int number) {
        
        //숫자의 갯수는 1~8개로 보면된다.
        for(int i=0;i<=8;i++)
        {
            dp.add(new HashSet<>()); // List 내부 초기화
        } // index를 1~8로 쓰기위해 9개를 넣는다.
        
        dp.get(1).add(N); // 1개로 만들수있는 숫자는 자기자신이다.
        
        for(int i=2;i<=8;i++)
        { //숫자 개수 2개부터 ~ 8개까지 만들수있는경우를 저장 및 체크한다.
            // 개수가 4라면 1,3 / 3,1/ 2,2의 조합이 된다.
            Set<Integer> storeTemp = dp.get(i); // i의 수갯수로 만들어지는 수들을 저장할 Set
            for(int j=1;j<i;j++) // 여기서 i는 수의 갯수, j는 조합을 만들기 위한 인덱스
            { // i - j(1~i-1) 로 모든 조합을 체크한다.
                Set<Integer> numsJ = dp.get(j);
                Set<Integer> numsIminusJ = dp.get(i-j);
                // 해당 갯수로 만들수있는 수들을 각각 가져온다.
                for(int num1 : numsJ)
                {
                    for(int num2 : numsIminusJ)
                    {
                        storeTemp.add(num1 * num2);
                        storeTemp.add(num1 - num2);
                        storeTemp.add(num1 + num2);
                        if(num1 != 0 && num2 != 0)
                        {
                            storeTemp.add(num1 / num2);
                        }
                        storeTemp.add(Integer.parseInt(String.valueOf(N).repeat(i)));
                        //이어붙인 수도 넣기
                        
                    }
      
                }
            
                
            }
            
            
        }
        
        for(int i=1;i<=8;i++)
        {
            if(dp.get(i).contains(number))
            {
                return i;
            }
        }
            
        
        return -1;
        
        
        
    }
}