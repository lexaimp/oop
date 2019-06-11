import java.io.Serializable;

public class SymmetricalMatrix implements Serializable {
    private static final long serialVersionUID = 1L;
    private int[][] matrix;

    public SymmetricalMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean isSymmetric() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[matrix.length - 1 - i][matrix[matrix.length - 1 - i].length - 1 - j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : matrix) {
            stringBuilder.append("{");
            for (int e : ints) {
                stringBuilder.append(e)
                        .append(" ,");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }
}
