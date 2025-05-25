public class numHalfPyramids {
    public static void main(String[] args) {
        int n=7;

        /*
            1 
            1 2 
            1 2 3 
            1 2 3 4 
            1 2 3 4 5 
            1 2 3 4 5 6 
            1 2 3 4 5 6 7 
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();


        /*
                  1
                 12
                123
               1234
              12345
             123456
            1234567
        */
        for (int i = 1; i <= n; i++) {
            //this prints the starting spaces
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            //print the number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();


        /*
            1 2 3 4 5 6 7
            1 2 3 4 5 6
            1 2 3 4 5
            1 2 3 4
            1 2 3
            1 2
            1
         */
        for (int i = n; i>= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();

        /*
            1
            2 3
            4 5 6
            7 8 9 10
            11 12 13 14 15
            16 17 18 19 20 21
            22 23 24 25 26 27 28
        */
        //this is called the floyd's traingle pattern sometimes
        int k=1;
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j <= i; j++) {
                //the counter k will be printed and updated
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }
        System.out.println();


        /*
            A
            B C
            D E F
            G H I J
            K L M N O
            P Q R S T U
            V W X Y Z [ \
        */
        char ch='A';
        //ch starts at A and then increments everytime it is printed 
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j <= i; j++) {
                //the counter ch will be printed and updated
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
        System.out.println();

        /*
            1
            2 2
            3 3 3
            4 4 4 4
            5 5 5 5 5
            6 6 6 6 6 6
            7 7 7 7 7 7 7
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //we just print the row number. if you start from 0, you can print i+1 or let it be 0
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();


        /*
                  1
                 22
                333
               4444
              55555
             666666
            7777777
        */
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <=n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();
    }
}
