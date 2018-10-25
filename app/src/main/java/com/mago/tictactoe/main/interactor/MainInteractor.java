package com.mago.tictactoe.main.interactor;

import com.mago.tictactoe.main.entities.Game;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public interface MainInteractor {
    void onCellClick(int row, int col, OnEventListener eventListener);
    void onRestart(Game game);

    interface OnEventListener{
        void showGameEnded(String winner);
        void resetGame();
    }
}
