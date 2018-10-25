package com.mago.tictactoe.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mago.tictactoe.db.TicTacToeContract;
import com.mago.tictactoe.db.entities.Score;

/**
 * Created by jorgemartinez on 25/10/18.
 */
@Dao
public interface ScoreDAO {
    @Insert
    long insertScore(Score score);
    @Update
    void updateScore(Score score);
    @Delete
    void deleteScore(Score score);

    @Query("SELECT * FROM "+ TicTacToeContract.ScoreData.TABLE_NAME)
    Score[] score();
}
