package com.mago.tictactoe.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class GameScorePreference {
    private Context context;

    private static final String SCORE_BOARD = "score_board";
    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final String DRAW = "draw";

    private SharedPreferences scorePref;
    private SharedPreferences.Editor editor;

    public GameScorePreference(Context context) {
        this.context = context;
        scorePref = context.getSharedPreferences(SCORE_BOARD, Context.MODE_PRIVATE);
        editor = scorePref.edit();
    }

    public int getPlayer1Score(){
        return scorePref.getInt(PLAYER1, 0);
    }

    public int getPlayer2Score(){
        return scorePref.getInt(PLAYER2, 0);
    }

    public int getDrawScore(){
        return scorePref.getInt(DRAW, 0);
    }

    public void clearData(){
        editor.putInt(PLAYER1, 0);
        editor.putInt(PLAYER2, 0);
        editor.putInt(DRAW, 0);
        editor.apply();
    }

    public void addPointPlayer1(){
        int points = scorePref.getInt(PLAYER1, 0);
        editor.putInt(PLAYER1, points+1);
        editor.apply();
    }

    public void addPointPlayer2(){
        int points = scorePref.getInt(PLAYER2, 0);
        editor.putInt(PLAYER2, points+1);
        editor.apply();
    }

    public void addPointDraw(){
        int points = scorePref.getInt(DRAW, 0);
        editor.putInt(DRAW, points+1);
        editor.apply();
    }
}
