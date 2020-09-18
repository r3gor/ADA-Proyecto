/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Pair;

/**
 *
 * @author rogrp
 */
public class TicTacToe {

    final public char VACIO = 'V';
    final public char PJ = 'X'; // primer jugador
    final public char SJ = 'O'; // segundo jugador
    int jugadas = 0;

    private char[][] board = new char[3][3];

    public TicTacToe() {
        // inicializa el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = VACIO;
            }
        }
        int jugadas = 0;
    }

    public char getTurno() {
        if (jugadas % 2 == 0) {
            return PJ; // primer jugador
        } else {
            return SJ; // segundo jugador
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getWinner() {

        if (board[0][0] != VACIO && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != VACIO && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] != VACIO && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != VACIO && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }

        return VACIO; // aun no hay ganador
    }

    public boolean setValue(int r, int c, char player) {
        System.out.println("\tJUGADAS: " + jugadas);
        if (board[r][c] == VACIO) {
            board[r][c] = player;
            jugadas++;
            printBoard();
            return true;
        } else {
            System.out.println("[Warning] La casilla (" + r + ", " + c + ") " + "no está vacía.");
            return false;
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }

    // AI
    private int minimax(int depth, boolean isMax, char ai, char p) {
        char winner = getWinner();
        if (winner == ai) {
            return 10 - depth;
        }
        if (winner == p) {
            return -10 + depth;
        }
        if (isFull()) {
            return 0;
        }

        if (isMax) {
            int bestVal = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != VACIO) {
                        continue;
                    }
                    board[i][j] = ai;
                    bestVal = Math.max(bestVal, minimax(depth + 1, !isMax, ai, p));
                    board[i][j] = VACIO;
                }
            }
            return bestVal;
        } else {
            int bestVal = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != VACIO) {
                        continue;
                    }
                    board[i][j] = p;
                    bestVal = Math.min(bestVal, minimax(depth + 1, !isMax, ai, p));
                    board[i][j] = VACIO;
                }
            }
            return bestVal;
        }
    }

    public void setSmartValue(char ai, char p, Pair move) {
        int valMax = -1000;
        int temp;
        int x = -1, y = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != VACIO) {
                    continue;
                }
                board[i][j] = ai;
                temp = minimax(0, false, ai, p);
                board[i][j] = VACIO;
                if (temp > valMax) {
                    x = i;
                    y = j;
                    valMax = temp;
                }
            }
        }
        System.out.println("IA: (" + x + ", " + y + ").");
        setValue(x, y, ai);
        move.x = x;
        move.y = y;
    }

    /*
    public static void main(String args[]) {
        TicTacToe ttt = new TicTacToe();
        ttt.setValue(0, 0, ttt.PJ);
        char ai = ttt.getTurno();
        char p = ai == 'X' ? 'O' : 'X';
        ttt.setSmartValue(ai, p, new Pair(0, 0));
    }
     */
}
