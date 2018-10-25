package com.mago.tictactoe.main.interactor;

import android.content.Context;

import com.mago.tictactoe.main.entities.Cell;
import com.mago.tictactoe.main.entities.Game;
import com.mago.tictactoe.main.entities.Player;
import com.mago.tictactoe.main.presenter.MainPresenter;
import com.mago.tictactoe.util.GameScorePreference;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class MainInteractorImpl implements MainInteractor{
    private Game game;
    private Cell[][] cells;
    private Player winner;

    private MainPresenter presenter;
    private GameScorePreference scorePreferences;

    public MainInteractorImpl(Game game, MainPresenter presenter, Context context) {
        this.game = game;
        cells = new Cell[3][3];
        winner = new Player();

        this.presenter = presenter;
        scorePreferences = new GameScorePreference(context);
    }

    @Override
    public void onCellClick(int row, int col, OnEventListener onEventListener) {
        if (game.getBoard()[row][col] == null){
            game.getBoard()[row][col] = new Cell(game.getCurrentPlayer());
            cells[row][col] = new Cell(game.getCurrentPlayer());
            presenter.drawCell(game.getCurrentPlayer().getValue());
            presenter.drawActualPlayer(game.getCurrentPlayer().getName());
            if (hasGameEnded()) {
                if (winner != null) {
                    gameEnded(true, onEventListener);
                }else {
                    gameEnded(false, onEventListener);
                }
                onEventListener.resetGame();
            } else {
                switchPlayer();
            }
        }
    }

    @Override
    public void onRestart(Game game) {
        this.game = game;
        cells = new Cell[3][3];
        winner = new Player();
    }

    private void gameEnded(boolean gotWinner, OnEventListener onEventListener){
        if (gotWinner) {
            if (winner.getName().equals("1"))
                scorePreferences.addPointPlayer1();
            else
                scorePreferences.addPointPlayer2();
            onEventListener.showGameEnded(winner.getName());
        } else {
            scorePreferences.addPointDraw();
            onEventListener.showGameEnded("");
        }

    }

    private void switchPlayer(){
        game.setCurrentPlayer(game.getCurrentPlayer() == game.getPlayer1()? game.getPlayer2() : game.getPlayer1());
    }

    private boolean hasGameEnded(){
        if (threeSameHorizontalCells() || threeSameVerticalCells() || threeSameDiagonalCells()){
            winner = game.getCurrentPlayer();
            return true;
        }

        if (isBoardFull()){
            winner = null;
            return true;
        }

        return false;
    }

    private boolean threeSameHorizontalCells(){
        for (int i=0; i<3; i++)
            if (areEqual(cells[i][0],cells[i][1], cells[i][2]))
                return true;

        return false;
    }

    private boolean threeSameVerticalCells(){
        for (int i=0; i<3; i++)
            if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                return true;

        return false;
    }

    private boolean threeSameDiagonalCells(){
        return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                areEqual(cells[0][2],cells[1][1],cells[2][0]);
    }

    private boolean isBoardFull(){
        for (Cell[] row : cells)
            for (Cell cell: row)
                if (cell == null || cell.isEmpty())
                    return false;

        return true;
    }

    private boolean areEqual(Cell... cells){
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells){
            if (cell == null || cell.getPlayer().getValue() == null || cell.getPlayer().getValue().length() ==0)
                return false;
        }

        Cell compareCell = cells[0];
        for (int i=1; i<cells.length; i++){
            if (!compareCell.getPlayer().getValue().equals(cells[i].getPlayer().getValue()))
                return false;
        }

        return true;
    }
}
