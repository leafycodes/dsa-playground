public class numPyramid {
    public static void main(String[] args) {
        int n=7;


        /*
                  1
                 121
                12321
               1234321
              123454321
             12345654321
            1234567654321
         */
        for (int i = 1; i <= n; i++) {
            int num=1;
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //number printing. i prefer the boolean logic

            // for (int j = 1; j <=2*i-1; j++) {
            //     System.out.print(num);
            //     if(j>=i){
            //         num--;
            //     }else{
            //         num++;
            //     }
            // }

            boolean increasing=true;
            while(num>0){
                System.out.print(num);
                if(num==i){
                    increasing=false;
                }
                if(increasing){
                    num++;
                }else{
                    num--;
                }
            }

            System.out.println();
        }
        System.out.println();

        /* 
                  1
                 212
                32123
               4321234
              543212345
             65432123456
            7654321234567
        */
        for (int i = 1; i <= n; i++) {
            int num=i;
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //i prefer the boolean logic. but this for loop can also be used just like the above one

            // for (int j = 1; j <=2*i-1; j++) {
            //     System.out.print(num);
            //     if(j>=i){
            //         num++;
            //     }else{
            //         num--;
            //     }
            // }

            boolean decreasing=true;
            while(num<=i){
                System.out.print(num);
                if(num==1){
                    decreasing=false;
                }
                if(decreasing){
                    num--;
                }else{
                    num++;
                }
            }

            System.out.println();
        }
        System.out.println();
    }
}
