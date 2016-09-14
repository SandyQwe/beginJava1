package geekbrains.java2.lesson2.homework;

/**
 * Created by sadmin on 14.09.2016.
 */
public class Matrix {
    private String[][] matrix;
    private int[][] numMatrix;

    public void Matrix(String line) throws IllegalSizeException {
        this.matrix = new String[4][4];
        this.numMatrix = new int[4][4];
        String[] newLine = line.split("\n");
        if (newLine.length < 4) throw new IllegalSizeException("Слишком мало строк (должно быть 4)");
        if (newLine.length > 4) throw new IllegalSizeException("Слишком много строк (должно быть 4)");
        for (int i = 0; i < newLine.length; i++) {
            this.SetLine(i, newLine[i]);
        }
    }

    public void SetLine(int row, String line) throws IllegalSizeException {
        String[] newLine = line.split(" ");
        if (newLine.length != 4) throw new IllegalSizeException("Неправильное количество столбцов (должно быть 4)");
        this.matrix[row] = newLine;
    }

    public void StringToInt (int row, String[] line){
        int[] newIntLine = new int[4];
        for (int i = 0; i < line.length; i++) {
            newIntLine[i] = Integer.getInteger(line[i]);
        }
        this.numMatrix[row] = newIntLine;
    }


}
