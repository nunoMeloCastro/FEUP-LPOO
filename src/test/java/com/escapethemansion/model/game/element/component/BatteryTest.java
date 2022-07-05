package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatteryTest {

    private Battery battery;

    @BeforeEach
    void setup() {
        this.battery = new Battery(50);
        this.battery.setColor("#FFFFFF");
    }

    @Test
    public void getValue(){
        assertEquals(this.battery.getValue(), 50);
    }

    @Test
    public void setValue(){
        this.battery.setValue(63);
        assertEquals(this.battery.getValue(), 63);
    }

    @Test
    public void getColor(){
        assertEquals(this.battery.getColor(), "#FFFFFF");
    }

    @Test
    public void setColor(){
        this.battery.setColor("#FF00FF");
        assertEquals(this.battery.getColor(), "#FF00FF");
    }

    @Test
    public void getAppearance(){
        assertEquals(this.battery.getAppearance(), "S");
    }

    @Test
    public void getInterval(){
        assertEquals(this.battery.getInterval(), new Position(8));
    }

    @Test
    public void getText(){
        assertEquals(this.battery.getText(), "battery");
    }

    @Test
    public void getPosition(){
        assertEquals(this.battery.getPosition(), new Position(1, 12));
    }

    @Test
    public void setPosition(){
        this.battery.setPosition(new Position(2, 12));
        assertEquals(this.battery.getPosition(), new Position(2, 12));
    }

    @Test
    public void decreaseValue(){
        this.battery.decreaseValue();
        assertEquals(this.battery.getValue(), 49);
    }

    @Test
    public void increaseValue(){
        this.battery.increaseValue();
        assertEquals(this.battery.getValue(), 51);
    }
}
