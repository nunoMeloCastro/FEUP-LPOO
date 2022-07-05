package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.component.Battery;
import com.escapethemansion.model.game.element.component.Fear;
import com.escapethemansion.model.game.element.component.Life;

public class Player extends Element {
    private Fear fear;
    private Life life;
    private Battery battery;
    private int numKeys;
    private int Strength;

    public Player(Position position) {
        super(position);
        this.life = new Life(100);
        this.fear = new Fear(0);
        this.battery = new Battery(100);
        this.appearance = "X";
        this.color = "#FFDE82";
        this.numKeys = 0;
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public Life getLife() {
        return life;
    }

    public Fear getFear() {
        return fear;
    }

    public Battery getBattery() {
        return battery;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void addKey() {
        numKeys++;
    }
}
