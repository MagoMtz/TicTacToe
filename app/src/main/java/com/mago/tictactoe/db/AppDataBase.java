package com.mago.tictactoe.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mago.tictactoe.db.dao.ScoreDAO;
import com.mago.tictactoe.db.entities.Score;

/**
 * Created by jorgemartinez on 25/10/18.
 */
@Database(version = 1, entities = {Score.class}, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase INSTANCE;

    abstract public ScoreDAO scoreDAO();

    public static AppDataBase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "tic_tac_toe_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
