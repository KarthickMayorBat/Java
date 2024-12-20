import java.util.ArrayList;

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        ArrayList<Integer> result = spiralOrder(mat);
        System.out.println(result); // Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }

    public static ArrayList<Integer> spiralOrder(int[][] mat) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns
        ArrayList<Integer> result = new ArrayList<>();
        
        int top = 0;       // Top boundary
        int bottom = n - 1; // Bottom boundary
        int left = 0;      // Left boundary
        int right = m - 1;  // Right boundary

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int j = left; j <= right; j++) {
                result.add(mat[top][j]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row (if still valid)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(mat[bottom][j]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
