import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, (o1,o2) -> {
    
            return -(o1+o2).compareTo(o2+o1);
            
        });
        
        String answer ="";
        for(String number : nums)
        {
            answer += number;
        }
        
        if(answer.charAt(0) == '0')
        {
            return "0";
        }
        
        return answer;
        
    }
}

/*
정렬 기준을 만든다.
자릿수가 같으면 큰 숫자가 먼저나온다.
자릿수가 다르면 자릿수가 작은게 앞으로간다.
*/