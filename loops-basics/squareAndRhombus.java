public class squareAndRhombus {
    public static void main(String[] args) {

        int n=7;
        /*
            * * * * * * *
            * * * * * * *
            * * * * * * *
            * * * * * * *
            * * * * * * *
            * * * * * * *
        */

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        /*
            * * * * * * *
            *           *
            *           *
            *           *
            *           *
            *           *
            * * * * * * *
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //print on boundary conditions
                if(i==1||i==n||j==1|j==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
                //added two spaces and one spae to make it look like a square on the terminal
            }
            System.out.println();
        }
        System.out.println();


        /*
                        * * * * * * *
                      * * * * * * *
                    * * * * * * *
                  * * * * * * *
                * * * * * * *
              * * * * * * *
            * * * * * * *
         */
        //a rhombus is a just a square with added sapces before it
        for (int i = 1; i <= n; i++) {
            //this prints the starting spaces
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            //this is same as square
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        /*
                        * * * * * * *
                      *           *
                    *           *
                  *           *
                *           *
              *           *
            * * * * * * *
        */
        for (int i = 1; i <= n; i++) {
            //this prints the starting spaces
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            //this is same as the hollow square above
            for (int j = 1; j <= n; j++) {
                //print on boundary conditions
                if(i==1||i==n||j==1|j==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
