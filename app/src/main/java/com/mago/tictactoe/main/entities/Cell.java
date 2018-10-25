package com.mago.tictactoe.main.entities;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class Cell {
    private Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty(){
        return player == null || (player.getValue()== null || player.getValue().length() == 0);
    }

    public Player getPlayer() {
        return player;
    }

}
