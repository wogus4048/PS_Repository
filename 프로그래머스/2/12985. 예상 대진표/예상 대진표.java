

class Solution
{
    public static int solution(int n, int a, int b)
    {
        int answer = 1;
        while(true){
            if (a % 2 == 0) {
                if(a-1 == b)break;
            }
            else{
                if(a+1 == b) break;
            }

            a = (a%2 == 0) ? a/2 : (int)Math.round(a/2.0);
            b = (b%2 == 0) ? b/2 : (int)Math.round(b/2.0);
            answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 5));
    }
}

