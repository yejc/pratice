package offer;

/**
 * 矩阵中的路径
 *
 * @author yejc
 * @date 2020/3/8 15:09
 */
public class MatrixPath {
    public boolean hasPath(char[][] matrix, String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (hasPathHelper(matrix, i, j, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathHelper(char[][] matrix, int i, int j, String str, boolean[][] visited) {
        if (str == null || str.length() == 0) {
            return true;
        }
        if (visited[i][j] || matrix[i][j] != str.charAt(0)) {
            return false;
        }
        visited[i][j] = true;
        // 向上走
        String nextStr = str.length() == 1 ? "" : str.substring(1);
        if (i > 0) {
            if (hasPathHelper(matrix, i - 1, j, nextStr, visited)) {
                return true;
            }
        }
        // 向下走
        if (i < matrix.length - 1) {
            if (hasPathHelper(matrix, i + 1, j, nextStr, visited)) {
                return true;
            }
        }
        // 向左走
        if (j > 0) {
            if (hasPathHelper(matrix, i, j - 1, nextStr, visited)) {
                return true;
            }
        }
        //向右走
        if (j < matrix[i].length - 1) {
            if (hasPathHelper(matrix, i, j + 1, nextStr, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        MatrixPath matrixPath = new MatrixPath();
        boolean hasPath = matrixPath.hasPath(matrix, "bfdehscf");
        System.out.println(hasPath);
    }
}
