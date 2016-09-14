package geekbrains.java2.lesson2.homework;

 class Matrix {
    private String[][] matrix;
    private int[][] numMatrix;

     Matrix(String line) throws IllegalMatrixException {
            this.matrix = SetMatrix(line);
            this.numMatrix = MatrixToInt(matrix);
    }

    private String[][] SetMatrix(String line) throws IllegalMatrixException {
        String[][] newMatrix = new String[4][4];
        String[] newLine = line.split("\\\\n");
        if (newLine.length < 4) {
            throw new IllegalMatrixException("Слишком мало строк (должно быть 4)");
        }
        if (newLine.length > 4) throw new IllegalMatrixException("Слишком много строк (должно быть 4)");
        for (int i = 0; i < newLine.length; i++) {
            String[] newElement = newLine[i].split(" ");
            if (newElement.length != 4) throw new IllegalMatrixException("Неправильное количество столбцов (должно быть 4)");
            newMatrix[i] = newElement;
        }
        return newMatrix;
    }

    private int[][] MatrixToInt (String[][] matrix) throws IllegalMatrixException {
        int[][] intMatrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try{
                    intMatrix[i][j] = Integer.parseInt(matrix[i][j]);
                }catch (NumberFormatException e){
                    throw new IllegalMatrixException("Один из элементов введённой матрицы не является числом");
                }
            }
        }
        return intMatrix;
    }

     float MatrixOperation(){
        float result = 0.0f;
        for (int i = 0; i < this.numMatrix.length; i++) {
            for (int j = 0; j < this.numMatrix[i].length; j++) result += this.numMatrix[i][j];
        }
        return result /= 2;
    }

     void ViewMatrix () {
        System.out.println("Ваша матрица:");
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                System.out.print(numMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }




}
