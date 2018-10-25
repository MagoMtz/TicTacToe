package com.mago.tictactoe.main.presenter;

import com.mago.tictactoe.main.entities.Game;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public interface MainPresenter {
    void onCellClick(int row, int col);
    void onRestart(Game game);
    void onDestroy();

    void drawCell(String value);
}
