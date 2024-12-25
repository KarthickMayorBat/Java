public class SetMatrixZeroes {
    public void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
    
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
    
        // Step 1: Check if the first row and column have zeros
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
    
        // Step 2: Use the first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;  // Mark row
                    mat[0][j] = 0;  // Mark column
                }
            }
        }
    
        // Step 3: Update inner matrix based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    
        // Step 4: Handle the first row and column
        if (firstColHasZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
    }
    
}
