package com.mago.tictactoe.main.entities;

/**
 * Created by jorgemartinez on 25/10/18.
 */
public class Player {
    private String name;
    private String value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
