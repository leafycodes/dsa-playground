public class butterfly {
    public static void main(String[] args) {
        int n=8;
        

        /*
            #              #
            ##            ##
            ###          ###
            ####        ####
            #####      #####
            ######    ######
            #######  #######
            ################
            ################
            #######  #######
            ######    ######
            #####      #####
            ####        ####
            ###          ###
            ##            ##
            #              #
        */

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }

            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }

            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
    }
}
