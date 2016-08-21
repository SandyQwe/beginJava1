package geekbrains.java1.lesson3.homework;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by sadmin on 21.08.2016.
 */
class NoughtsAndCrosses {
    final char HUMAN_DOT = 'X';
    final char AI_DOT = 'O';
    final char EMPTY_DOT = '*';
    final Scanner scanner = new Scanner(System.in);
    final Random rnd = new Random();
    int fieldSizeY;
    int fieldSizeX;
    int line;
    char[][] field;
    int[] lastCell = {0, 0};

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
        do fieldSizeX = scanner.nextInt(); while (fieldSizeX >2);
        System.out.println("Введите количество строк, больше 2 (y): ");
        do fieldSizeY = scanner.nextInt(); while (fieldSizeY >2);
        System.out.println("Введите длину последовательности знаков (больше 2): ");
        do line = scanner.nextInt(); while (line >2);
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void printMap() {
        System.out.print("+ ");
        for (int i = 1; i <= fieldSizeX; i++) System.out.println(i + " ");
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < fieldSizeX; j++) System.out.println(field[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private boolean mapIsFull(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private boolean checkWin(char c){
        return false;
    }

    private void humanTurn(){


    }

    private void aiTurn(){

    }

    private boolean validCell (int x, int y){
        return true;
    }

    private boolean emptyCell (int x, int y) {
        return true;
    }

}
