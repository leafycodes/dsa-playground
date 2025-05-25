public class sumDigitsAndPalindromeAndReverseNum {
    public static void main(String[] args) {
        System.out.println(reverse(12043));
        System.out.println(isPalindrome(12321) ? "palindrome" : "not palindrome");
        System.out.println(sumOfDigits(12345));
    }

    public static int reverse(int num) {
        int rev = 0;

        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        return rev;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        return sum;
    }

    public static boolean isPalindrome(int num) {
        int rev = reverse(num);
        if (rev == num) {
            return true;
        }
        return false;
    }
}
