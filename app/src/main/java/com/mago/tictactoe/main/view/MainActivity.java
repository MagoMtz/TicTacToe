package com.mago.tictactoe.main.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.mago.tictactoe.R;
import com.mago.tictactoe.databinding.ActivityMainBinding;
import com.mago.tictactoe.main.entities.Game;
import com.mago.tictactoe.main.presenter.MainPresenter;
import com.mago.tictactoe.main.presenter.MainPresenterImpl;
import com.mago.tictactoe.util.GameScorePreference;

public class MainActivity extends AppCompatActivity implements MainView {
    private ActivityMainBinding view;
    private MainPresenter presenter;
    private Button button;
    private GameScorePreference scorePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scorePreference = new GameScorePreference(this);
        Game game = new Game("1", "2");
        presenter = new MainPresenterImpl(this, game, this);

        view = DataBindingUtil.setContentView(this, R.layout.activity_main);

        view.btnRestart.setOnClickListener((view) -> {
            restartGame();
            cleanBoard();
        });
        view.btnCleanScoreboard.setOnClickListener((view) -> {
            resetScoreBoard();
        });
        setClickListeners();
        drawScore();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void drawScore(){
        int p1Score = scorePreference.getPlayer1Score();
        int p2Score = scorePreference.getPlayer2Score();
        int drawScore = scorePreference.getDrawScore();
        view.lblP1Score.setText(String.valueOf(p1Score));
        view.lblP2Score.setText(String.valueOf(p2Score));
        view.lblDrawScore.setText(String.valueOf(drawScore));
    }

    private void setClickListeners(){
        view.cell11.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(0,0);
        });
        view.cell12.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(0,1);
        });
        view.cell13.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(0,2);
        });
        view.cell21.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(1,0);
        });
        view.cell22.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(1,1);
        });
        view.cell23.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(1,2);
        });
        view.cell31.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(2,0);
        });
        view.cell32.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(2,1);
        });
        view.cell33.setOnClickListener((view)->{
            button = (Button) view;
            presenter.onCellClick(2,2);
        });
    }

    private void restartGame(){
        Game game = new Game("1", "2");
        presenter.onRestart(game);
    }

    private void cleanBoard(){
        view.cell11.setText(null);
        view.cell12.setText(null);
        view.cell13.setText(null);
        view.cell21.setText(null);
        view.cell22.setText(null);
        view.cell23.setText(null);
        view.cell31.setText(null);
        view.cell32.setText(null);
        view.cell33.setText(null);
    }

    private void resetScoreBoard(){
        scorePreference.clearData();
        view.lblP1Score.setText("0");
        view.lblP2Score.setText("0");
        view.lblDrawScore.setText("0");
        view.lblActualPlayer.setText("1");
        restartGame();
        cleanBoard();
    }

    @Override
    public void showGameEnded(String winner) {
        showGameEndedDialog(winner);
        drawScore();
    }

    @Override
    public void drawCell(String value) {
        button.setText(value);
    }

    @Override
    public void drawActualPlayer(String actualPlayer) {
        actualPlayer = actualPlayer.equals("1") ? "2" : "1";
        view.lblActualPlayer.setText(actualPlayer);
    }

    private void showGameEndedDialog(String winner){
        String msg;
        if (!winner.isEmpty()) {
            msg = String.format(getString(R.string.activity_main_end_game_dialog_win_msg), winner);
        }else {
            msg = getString(R.string.activity_main_end_game_dialog_draw_msg);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.activity_main_end_game_dialog_title));
        builder.setMessage(msg);
        builder.setPositiveButton(getString(R.string.activity_main_end_game_dialog_btn_restart), (dialog, which) -> {
            restartGame();
            cleanBoard();
        });
        builder.setNegativeButton(getString(R.string.activity_main_end_game_dialog_btn_ok), (dialog, which) -> {
            dialog.dismiss();
        });
        builder.create().show();
    }


}
