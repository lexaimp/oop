import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SymmetricalMatrix implements Serializable {
    private static final long serialVersionUID = 1L;
    private int[][] matrix;

    SymmetricalMatrix(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть меньше 1");
        }
        this.matrix = new int[dimension][dimension];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = (int) (Math.random() * 25);
                matrix[i][j] = value;
                matrix[matrix.length - 1 - i][matrix[matrix.length - 1 - i].length - 1 - j] = value;
            }
        }
    }

    private void writeObject(ObjectOutputStream out) {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("(");
        for (int[] ints : matrix) {
            stringBuilder.append("{");
            for (int e : ints) {
                stringBuilder.append(e)
                        .append(", ");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append("}, ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append(")").toString();
    }
}
