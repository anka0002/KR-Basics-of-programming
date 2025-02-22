public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int[][] getData() {
        return data;
    }

    public Matrix add(Matrix other) {
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.data[i][j] + other.data[i][j]);
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.data[i][j] - other.data[i][j]);
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        int rows = data.length;
        int cols = other.data[0].length;
        int commonDim = data[0].length;
        Matrix result = new Matrix(rows, cols);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < commonDim; k++) {
                    result.setValue(i, j, result.getData()[i][j] + this.data[i][k] * other.data[k][j]);
                }
            }
        }
        return result;
    }

    public void print() {
        for (int[] row : data) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
