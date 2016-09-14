package geekbrains.java2.lesson2.homework;

public class Matrix {
    private String[][] matrix;
    private int[][] numMatrix;

    public Matrix(String line) throws IllegalSizeException {
//        this.matrix = new String[4][4];
//        this.numMatrix = new int[4][4];
        this.matrix = SetMatrix(line);
        this.numMatrix = MatrixToInt(matrix);
//        for (int i = 0; i < newLine.length; i++) {
//            this.SetLine(i, newLine[i]);
//            this.StringToInt(i, this.matrix[i]);
//        }
    }

    private String[][] SetMatrix(String line) throws IllegalSizeException {
        String[][] newMatrix = new String[4][4];
        String[] newLine = line.split("\n");
        if (newLine.length < 4) throw new IllegalSizeException("Слишком мало строк (должно быть 4)");
        if (newLine.length > 4) throw new IllegalSizeException("Слишком много строк (должно быть 4)");
        for (int i = 0; i < newLine.length; i++) {
            String[] newElement = newLine[i].split(" ");
            if (newElement.length != 4) throw new IllegalSizeException("Неправильное количество столбцов (должно быть 4)");
            newMatrix[i] = newElement;
        }
        return newMatrix;
    }

    private int[][] MatrixToInt (String[][] matrix){
        int[][] intMatrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                intMatrix[i][j] = Integer.getInteger(matrix[i][j]);
            }
        }
        return intMatrix;
    }


}
