package geekbrains.java2.lesson2.homework;

class IllegalMatrixException extends RuntimeException {
    private String description;

    IllegalMatrixException(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "IllegalMatrixException:" + description;
    }
}
