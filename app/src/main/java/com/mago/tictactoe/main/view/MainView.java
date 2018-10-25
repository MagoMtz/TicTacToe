package com.mago.tictactoe.main.view;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public interface MainView {
    void showGameEnded(String winner);

    void drawCell(String value);
    void drawActualPlayer(String actualPlayer);
}
