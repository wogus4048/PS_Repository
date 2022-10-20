import java.util.*;

public class Solution {
    public static int solution(int[] nums) {
        int answer = nums.length/2;

        Integer[] nums2 = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            nums2[i] = Integer.valueOf(nums[i]);
        }

        Set<Integer> set = new HashSet<>(Arrays.asList(nums2));

        if(set.size() < answer)
        {
            answer = set.size();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {3,3,3,2,2,4};
        System.out.println(solution(a));


    }


}