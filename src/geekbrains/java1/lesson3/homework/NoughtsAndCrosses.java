package geekbrains.java1.lesson3.homework;

import java.util.Random;
import java.util.Scanner;

class NoughtsAndCrosses {
    private final char HUMAN_DOT = 'X';
    private final char AI_DOT = 'O';
    private final char EMPTY_DOT = '*';
    private final Scanner scanner = new Scanner(System.in);
    private final Random rnd = new Random();
    private int fieldSizeY;
    private int fieldSizeX;
    private int line;
    private char[][] field;
    private int[] lastCell = {0, 0};

    void play() {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Выиграл игрок");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(AI_DOT)) {
                System.out.println("Выиграл компьютер");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        scanner.close();

    }


    private void initMap() {
        System.out.println("Введите количество столбцов, больше 2 (x): ");
        do fieldSizeX = scanner.nextInt(); while (fieldSizeX <= 2);
        System.out.println("Введите количество строк, больше 2 (y): ");
        do fieldSizeY = scanner.nextInt(); while (fieldSizeY <= 2);
        System.out.println("Введите длину последовательности знаков (больше 2): ");
        do line = scanner.nextInt(); while (line <= 2);
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void printMap() {
        System.out.print("+ ");
        for (int i = 1; i <= fieldSizeX; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < fieldSizeX; j++) System.out.print(field[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private boolean mapIsFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private boolean checkWin(char c) {
        int winLine = 0; //переменная для подсчёта длины линии
        int x = lastCell[0]; // для удобства чтобы не путаться
        int y = lastCell[1];
        //проверка вертикалей
        for (int i = y; i >= 0; i--)
            if (field[i][x] == c) {
                if (++winLine == line) return true;
            } else break;
        for (int i = y + 1; i < fieldSizeY; i++)
            if (field[i][x] == c) {
                if (++winLine == line) return true;
            } else break;
        //проверка горизонталей
        winLine = 0;
        for (int i = x; i >= 0; i--)
            if (field[y][i] == c) {
                if (++winLine == line) return true;
            } else break;
        for (int i = x + 1; i < fieldSizeX; i++)
            if (field[y][i] == c) {
                if (++winLine == line) return true;
            } else break;
        //проверка диагонали слева сверху вправо вниз
        winLine = 0;
        for (int i = 0; i <= (x <= y ? x : y); i++)
            if (field[y - i][x - i] == c) {
                if (++winLine == line) return true;
            } else break;
        for (int i = 1; i < (fieldSizeX - x < fieldSizeY - y ? fieldSizeX - x : fieldSizeY - y); i++)
            if (field[y + i][x + i] == c) {
                if (++winLine == line) return true;
            } else break;
        //проверка диагонали слева снизу вправо вверх
        winLine = 0;
        for (int i = 0; i <= (fieldSizeY - y - 1 < x ? fieldSizeY - y - 1 : x); i++)
            if (field[y + i][x - i] == c) {
                if (++winLine == line) return true;
            } else break;
        if (y != 0 && x != fieldSizeX - 1)
            for (int i = 1; i <= (y < fieldSizeX - x - 1 ? y : fieldSizeX - x - 1); i++)
                if (field[y - i][x + i] == c) {
                    if (++winLine == line) return true;
                } else break;
        return false;
    }

    private void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты (столбец, строка) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!validCell(x, y) || !emptyCell(x, y));
        lastCell[0] = x;
        lastCell[1] = y;
        field[y][x] = HUMAN_DOT;
    }

    private void aiTurn() {
        int x, y;
        if (aiCanBlock(lastCell[0], lastCell[1])) {
            x = lastCell[0];
            y = lastCell[1];
        } else {
            do {
                x = rnd.nextInt(fieldSizeX);
                y = rnd.nextInt(fieldSizeY);
            } while (!emptyCell(x, y));
            lastCell[0] = x;
            lastCell[1] = y;
        }
        field[y][x] = AI_DOT;
    }

    private boolean aiCanBlock(int x, int y) {
        //пока просматривает только смежные символы начиная с последнего, который поставил игрок
        // ввести переменную типа byte каждый из битов которой будет означать конкретное направление
        // установки нолика

        //проверка на возможность блока справа
        if (x > 0 && field[y][x - 1] == HUMAN_DOT && validCell(x + 1, y) && emptyCell(x + 1, y)) {
            lastCell[0] = x + 1;
            lastCell[1] = y;
            return true;
        }
        //проверка на возможность блока слева
        if (x < fieldSizeX - 1 && field[y][x + 1] == HUMAN_DOT && validCell(x - 1, y) && emptyCell(x - 1, y)) {
            lastCell[0] = x - 1;
            lastCell[1] = y;
            return true;
        }
        //проверка на возможность блока снизу
        if (y > 0 && field[y - 1][x] == HUMAN_DOT && validCell(x, y + 1) && emptyCell(x, y + 1)) {
            lastCell[0] = x;
            lastCell[1] = y + 1;
            return true;
        }
        //проверка на возможность блока сверху
        if (y < fieldSizeY - 1 && field[y + 1][x] == HUMAN_DOT && validCell(x, y - 1) && emptyCell(x, y - 1)) {
            lastCell[0] = x;
            lastCell[1] = y - 1;
            return true;
        }
        //проверка на возможность блока снизу справа
        if (x > 0 && y > 0 && field[y - 1][x - 1] == HUMAN_DOT && validCell(x + 1, y + 1) && emptyCell(x + 1, y + 1)) {
            lastCell[0] = x + 1;
            lastCell[1] = y + 1;
            return true;
        }
        //проверка на возможность блока снизу слева
        if (y > 0 && x < fieldSizeX - 1 && field[y - 1][x + 1] == HUMAN_DOT && validCell(x - 1, y + 1) && emptyCell(x - 1, y + 1)) {
            lastCell[0] = x - 1;
            lastCell[1] = y + 1;
            return true;
        }
        //проверка на возможность блока сверху справа
        if (x > 0 && y < fieldSizeY - 1 && field[y + 1][x - 1] == HUMAN_DOT && validCell(x + 1, y - 1) && emptyCell(x + 1, y - 1)) {
            lastCell[0] = x + 1;
            lastCell[1] = y - 1;
            return true;
        }
        //проверка на возможность блока сверху слева
        if (x < fieldSizeX - 1 && y < fieldSizeY - 1 && field[y + 1][x + 1] == HUMAN_DOT && validCell(x - 1, y - 1) && emptyCell(x - 1, y - 1)) {
            lastCell[0] = x - 1;
            lastCell[1] = y - 1;
            return true;
        }
        //если нигде нет сдвоенных знаков, то будем пока считать, что блокировать нельзя
        return false;
    }

    private boolean validCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean emptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

}
