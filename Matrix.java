public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public Matrix add(Matrix other) {
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
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
                result.setValue(i, j, this.getValue(i, j) - other.getValue(i, j));
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
                    result.setValue(i, j, result.getValue(i, j) + this.getValue(i, k) * other.getValue(k, j));
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

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValue(0, 0, 1);
        matrix1.setValue(0, 1, 2);
        matrix1.setValue(1, 0, 3);
        matrix1.setValue(1, 1, 4);

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setValue(0, 0, 5);
        matrix2.setValue(0, 1, 6);
        matrix2.setValue(1, 0, 7);
        matrix2.setValue(1, 1, 8);

        System.out.println("Matrix 1:");
        matrix1.print();

        System.out.println("Matrix 2:");
        matrix2.print();

        Matrix sum = matrix1.add(matrix2);
        System.out.println("Sum:");
        sum.print();

        Matrix difference = matrix1.subtract(matrix2);
        System.out.println("Difference:");
        difference.print();

        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Product:");
        product.print();
    }
}