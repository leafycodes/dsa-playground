public class diamonds {
    public static void main(String[] args) {
        int n = 7;

        /*
         *       #
         *      ###
         *     #####
         *    #######
         *   #########
         *  ###########
         * #############
         *  ###########
         *   #########
         *    #######
         *     #####
         *      ###
         *       #
         */
        // this is the top half of the diamond
        // just a block to show the two outer loops together, this block {} does not
        // affect the code
        {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }

            // this is the bottom half of the diamond, just reverse the outer loop
            // started from one column less to not repeat the middle row
            for (int i = n - 1; i >= 1; i--) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }
        System.out.println();

        /*
         *  ###### ######
            #####   #####
            ####     ####
            ###       ###
            ##         ##
            #           #
            #           #
            ##         ##
            ###       ###
            ####     ####
            #####   #####
            ###### ######
         */

        // this is the same code jsut changed "#" and " "
        // also added "#" for top right and bottom right part

        // the top loop goes till n-1 to not leave any gaps in the middle row

        // to remove sapces from top and bottom jsut run the spaces till <2*i-1
        {
            for (int i = 1; i <= n - 1; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print("#");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= n - i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }

            // this is the bottom half of the diamond, just reverse the outer loop
            // started from one column less to not repeat the middle row
            for (int i = n - 1; i >= 1; i--) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print("#");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= n - i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }
        System.out.println();


        /*
                  #
                 # #
                #   #
               #     #
              #       #
             #         #
            #           #
             #         #
              #       #
               #     #
                #   #
                 # #
                  #
         */
        {
            int spaces=1;
            for (int i = 1; i <= 2*n-1; i++) {
                for (int j = 1; j <= Math.abs(n-i); j++) {
                        System.out.print(" ");
                    }

                if(i==1||i==2*n-1){
                    System.out.print("#");
                }else{
                    System.out.print("#");

                    for (int j = 1; j <= spaces; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("#");

                    if(i<n){
                        spaces+=2;
                    }else{
                        spaces-=2;
                    }
                }
                System.out.println();
            }
        }

    }
}
