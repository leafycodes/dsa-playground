/* 5.1 Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space to fit all of M. That is, if M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.

EXAMPLE
Input: N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100

Hints: #137, #769, #215 */

public class five_one {
    public static void main(String[] args) {
        int N = 0b10000000000, M = 0b10011, i = 2, j = 6;
        // output should be 10001001100

        int leftBitMask = (~0 << (j + 1));
        int rightBitMask = ((1 << i) - 1);

        int bitMask = leftBitMask | rightBitMask;
        M <<= i;

        String res = Integer.toBinaryString((N & bitMask) | M);
        System.out.println(res);
    }
}