package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;

public class Battery extends PlayerComponent{
    public Battery(int value) {
        super(value);
        this.color = "#F4EB49";
        this.text = "battery";
        this.position = new Position(1, 12);
    }
}
