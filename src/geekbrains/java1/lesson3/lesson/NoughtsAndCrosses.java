package geekbrains.java1.lesson3.lesson;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Александр on 18.08.2016.
 */
class NoughtsAndCrosses {

    final char HUMAN_DOT = 'X';
    final char AI_DOT = 'O';
    final char EMPTY_DOT = '*';
    final Scanner scanner = new Scanner(System.in);
    final Random rnd = new Random();
    int fieldSizeY;
    int fieldSizeX;
    char[][] field;


    void doIt() {
        initMap(3, 3);
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

    private boolean checkWin(char c) {
        return false;
    }

    private boolean mapIsFull() {
        return false;
    }

    private void humanTurn() {
    }

    private void aiTurn() {

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

    private void initMap(int y, int x) {
        fieldSizeX = x;
        fieldSizeY = y;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }
}
