public class rowWiseBinarySearch {
    public static void main(String[] args) {
        int key = 9;
        int matrix[][] = {
                { 2, 3, 7 },
                { 4, 5, 9 },
                { 1, 6, 8 }
        };
        int[] res = search(matrix, key);
        System.out.println(res[0] != -1 ? "found at " + res[0] + ", " + res[1] : "NOT FOUND");
    }

    private static int[] search(int matrix[][], int key) {
        // basically binary search for every row. given each row is sorted

        // O(n*logm)
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (matrix[i][mid] == key) {
                    return new int[] { i, mid };
                } else if (matrix[i][mid] > key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
