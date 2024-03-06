class Solution {
    public int solution(int n) {
        int number= n+1;
        String nBinary = Integer.toString(n,2);
        int nOne =0;
        char[] a = nBinary.toCharArray();
        for(int i=0;i<nBinary.length();i++)
        {
            if(a[i] == '1') nOne ++;
        }
        
        while(true)
        {
            String tempBinary = Integer.toString(number,2);
            char[] tC = tempBinary.toCharArray();
            int temp =0;
            for(int i=0;i<tempBinary.length();i++)
            {
                if(tC[i] == '1') temp ++;
            }
                
           
            if(nOne == temp)
            {
                return number;
            }
            number++;
        
        }

    }
}