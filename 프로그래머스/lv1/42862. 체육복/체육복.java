// package practice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j]) ) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        
        




        return answer;
    }

    public static void main(String[] args) {
        solution(5, new int[]{2, 4}, new int[]{1,3,5});
    }








}
