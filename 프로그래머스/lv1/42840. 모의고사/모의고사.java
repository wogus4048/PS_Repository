import java.util.*; 

class Solution {
    public List<Integer> solution(int[] answers) {
        int answer1 =0,answer2 =0 ,answer3 =0 ;
        Integer[] t1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] t2 = new Integer[]{2, 1, 2, 3, 2, 4, 2, 5};
        Integer[] t3 = new Integer[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        Queue<Integer> method1 = new LinkedList<>(Arrays.asList(t1));
        Queue<Integer> method2 = new LinkedList<>(Arrays.asList(t2));
        Queue<Integer> method3 = new LinkedList<>(Arrays.asList(t3));
        
        for(int n : answers)
        {
            // System.out.println("n :" +n);
            // System.out.println("method1.peek():" +method1.peek());
            // System.out.println("method2.peek():" +method2.peek());
            // System.out.println("method3.peek():" +method3.peek());
            if(method1.peek() == n)
            {
                answer1++;
            }
            method1.add(method1.poll());
            
            if(method2.peek() == n)
            {
                answer2++;
            }
            method2.add(method2.poll());
            
            if(method3.peek() == n)
            {
                answer3++;
            }
            method3.add(method3.poll());
            // System.out.println("answer1 :" +answer1);
            // System.out.println("answer2 :" +answer2);
            // System.out.println("answer3 :" +answer3);
        }
        int maxcount = Math.max(answer1,Math.max(answer2,answer3));
        List<Integer> r = new ArrayList<>();
        if(answer1 == maxcount)
        {
            r.add(1);
        }
        if(answer2 == maxcount)
        {
            r.add(2);
        }
        if(answer3 == maxcount)
        {
            r.add(3);
        }
        return r;
        
    }
}