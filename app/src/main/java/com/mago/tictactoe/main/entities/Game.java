package com.mago.tictactoe.main.entities;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Cell[][] board;

    public Game(String playerOne, String playerTwo) {
        player1 = new Player(playerOne, "X");
        player2 = new Player(playerTwo, "O");
        currentPlayer = player1;
        board = new Cell[3][3];
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Cell[][] getBoard() {
        return board;
    }

}
