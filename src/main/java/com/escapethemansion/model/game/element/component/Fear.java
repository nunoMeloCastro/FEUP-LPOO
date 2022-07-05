package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;

public class Fear extends PlayerComponent{
    public Fear(int value) {
        super(value);
        this.color = "#7E2199";
        this.text = "fear";
        this.position = new Position(1, 10);
    }

    @Override
    public void increaseValue() {
        this.value += 5;
    }
}
