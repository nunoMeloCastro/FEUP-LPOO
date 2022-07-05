package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Weapon extends Element{

    private int power;

    public Weapon(Position position) {
        super(position);
        this.appearance = "W";
        this.color = "#FF0000";
        this.power = 50;
    }

    public int getPower() {
        return power;
    }
}
