import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        int min = Arrays.stream(arr).min().getAsInt();
        return arr.length != 1 ? Arrays.stream(arr).filter((v) -> v != min).toArray() : new int[]{-1};
        
    }
}