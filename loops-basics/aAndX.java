public class aAndX {
    public static void main(String[] args) {
        int n=7;

        /*
            #     #
             #   #
              # #
               #
              # #
             #   #
            #     #
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j||i+j==n+1){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();


        /*
            #######
            #     #
            #     #
            #######
            #     #
            #     #
            #     #

        */
        //trying the initial of my first name
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==1||i==(n+1)/2||j==1||j==n){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
