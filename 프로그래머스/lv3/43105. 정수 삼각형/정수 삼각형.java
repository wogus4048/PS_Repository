class Solution {
    public static int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][triangle.length]; //각 자리별 최대값을 저장할 2차원배열
        dp[0][0] = triangle[0][0];

        for(int i=1;i<triangle.length;i++) // 삼각형의 양쪽 끝부분에 존재하는값들은 위에값과 자신값을 더한것이 최대값이므로 미리 최대값을 채워넣을 수 있다.
        {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        for(int i=2;i<triangle.length;i++)
        {
            for(int j=1;j < i;j++)
            {
                dp[i][j] = Math.max(dp[i-1][j-1] ,dp[i-1][j] ) + triangle[i][j];
            }
        }

        int max_result = dp[triangle.length-1][0];

        for(int i=1;i<triangle.length;i++)
        {
            if(max_result < dp[triangle.length-1][i])
            {
                max_result = dp[triangle.length-1][i];
            }
        }

        return max_result;


    }

    public static void main(String[] args)
    {
        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(input));

    }
}