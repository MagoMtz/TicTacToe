package com.mago.tictactoe.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.mago.tictactoe.db.TicTacToeContract;

/**
 * Created by jorgemartinez on 25/10/18.
 */
@Entity(tableName = TicTacToeContract.ScoreData.TABLE_NAME,
        indices = @Index(value = TicTacToeContract.ScoreData._ID))
public class Score {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TicTacToeContract.ScoreData._ID)
    private long id;
    @ColumnInfo(name = TicTacToeContract.ScoreData.P1_WINS)
    private int p1Wins;
    @ColumnInfo(name = TicTacToeContract.ScoreData.P2_WINS)
    private int p2Wins;
    @ColumnInfo(name = TicTacToeContract.ScoreData.DRAWS)
    private int draws;

    public Score() {
    }

    @Ignore
    public Score(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getP1Wins() {
        return p1Wins;
    }

    public void setP1Wins(int p1Wins) {
        this.p1Wins = p1Wins;
    }

    public int getP2Wins() {
        return p2Wins;
    }

    public void setP2Wins(int p2Wins) {
        this.p2Wins = p2Wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }
}
