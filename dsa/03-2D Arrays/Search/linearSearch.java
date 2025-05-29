public class linearSearch {
    public static void main(String[] args) {
        int key = 1;
        int matrix[][] = {
                { 8, 3, 2 },
                { 5, 4, 9 },
                { 8, 1, 6 }
        };
        int[] res = search(matrix, key);
        System.out.println(res[0] != -1 ? "found at " + res[0] + ", " + res[1] : "NOT FOUND");
    }

    private static int[] search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}