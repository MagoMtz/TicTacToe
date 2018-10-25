package com.mago.tictactoe.db;

import android.provider.BaseColumns;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class TicTacToeContract {

    public static abstract class ScoreData implements BaseColumns {
        public static final String TABLE_NAME = "score";
        public static final String P1_WINS = "p1_wins";
        public static final String P2_WINS = "p2_wins";
        public static final String DRAWS = "draws";
    }

}
