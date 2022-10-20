import java.util.*;
class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
//        System.out.println("phone_book = " + Arrays.toString(phone_book));

        for(int i=0;i< phone_book.length-1;i++)
        {
            if(phone_book[i+1].startsWith(phone_book[i]))
            {
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] r = {"119", "97674223", "1195524421","19"};
        System.out.println(solution(r));
    }
}