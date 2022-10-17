

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int result = 0;
        for(int i=1;i<=number;i++)
        {
            String current_number = Integer.toString(i);

            for(int j=0;j<current_number.length();j++)
            {
                if(current_number.charAt(j) == '3' || current_number.charAt(j) == '6' || current_number.charAt(j) == '9')
                {
                    result ++;
                }
            }
        }

        System.out.println(result);

    }
}
