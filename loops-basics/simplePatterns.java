public class simplePatterns{
    public static void main(String[] args) {
        int n=7;
        /*
            *  
            * * 
            * * * 
            * * * * 
            * * * * * 
            * * * * * * 
            * * * * * * * 
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        /*
            * * * * * * *  
            * * * * * *
            * * * * *
            * * * *
            * * *
            * *
            *
        */

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();


        /*
                  *
                 **
                ***
               ****
              *****
             ******
            *******
        */
        for (int i = 1; i <= n; i++) {
            //this prints the starting spaces
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            //print the stars here
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        /*
            *******
            ******
            *****
            ****
            ***
            **
            *
        */
        for (int i = 1; i <= n; i++) {
            //this prints the starting spaces
            for (int j = 1; j <= i-1; j++) {
                System.out.print(" ");
            }
            //print the stars here
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}