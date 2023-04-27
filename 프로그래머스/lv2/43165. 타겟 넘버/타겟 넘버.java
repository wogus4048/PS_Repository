import java.util.*;

class Solution {
    // static boolean[] visited;
    static int count=0;

    static public int solution(int[] numbers, int target) {
        // visited = new boolean[numbers.length];

        dfs(numbers,target,0,0);

        System.out.println(count);
        return count;
    }

    static void dfs(int[] numbers , int target, int sum, int index)
    {
        if(index == numbers.length){

            if(sum == target)
            {
                count++;
            }
            return;
        }

        dfs(numbers,target,sum+numbers[index],index+1);
        dfs(numbers,target,sum-numbers[index],index+1);


    }
}
