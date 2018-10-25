package com.mago.tictactoe.main.presenter;

import android.content.Context;

import com.mago.tictactoe.main.entities.Game;
import com.mago.tictactoe.main.interactor.MainInteractor;
import com.mago.tictactoe.main.interactor.MainInteractorImpl;
import com.mago.tictactoe.main.view.MainView;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class MainPresenterImpl implements MainPresenter, MainInteractor.OnEventListener {
    private MainInteractor mainInteractor;
    private MainView mainView;

    public MainPresenterImpl(MainView mainView, Game game, Context context) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl(game, this, context);
    }

    @Override
    public void onCellClick(int row, int col) {
        mainInteractor.onCellClick(row, col, this);
    }

    @Override
    public void onRestart(Game game) {
        mainInteractor.onRestart(game);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void drawCell(String value) {
        mainView.drawCell(value);
    }

    @Override
    public void showGameEnded(String winner) {
        mainView.showGameEnded(winner);
    }

    @Override
    public void resetGame() {

    }


}
