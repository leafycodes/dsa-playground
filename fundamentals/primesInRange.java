public class primesInRange {
    public static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int low = 2;
        int high = 1000;

        for (int i = low; i < high; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
