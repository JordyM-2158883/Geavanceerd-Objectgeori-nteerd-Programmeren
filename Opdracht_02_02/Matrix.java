public class Matrix {
    private int[][] matrix;
    final public int SIZE = 3;

    public Matrix() {
        matrix = new int[3][3];
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                matrix[y][x] = 0;
            }
        }
    }

    public void print() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
    }

    public void add(Matrix m) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                this.matrix[y][x] += m.matrix[y][x];
            }
        }
    }
}