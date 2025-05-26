public class byReference {
    public static void main(String[] args) {
        // in function calls in java, the formal parameters are called by value. i.e.

        int a = 5, b = 10;
        System.out.println("before swap: a= " + a + ", b= " + b);
        swap(a, b);
        System.out.println("after swap: a= " + a + ", b= " + b);

        // but if you pass an array in a function, it gets passed BY REFERENCE

        int[] arr = { a, b };
        System.out.println("before swap: arr[0]= " + arr[0] + ", arr[1]= " + arr[1]);
        // since the array is passed by reference, the actual values too are affected
        swap(arr);
        System.out.println("before swap: arr[0]= " + arr[0] + ", arr[1]= " + arr[1]);
    }

    public static void swap(int a, int b) {
        a = (a + b) - (b = a);
        /*
         * you can try different wasy to swap but they do not affect the actual
         * arguments in the main fucntion
         */

        // int temp=a;
        // a=b;
        // b=temp;

        // a=a^b;
        // b=a^b;
        // a=a^b;
    }

    public static void swap(int[] arr) {
        arr[0] = (arr[0] + arr[1]) - (arr[1] = arr[0]);
    }
}