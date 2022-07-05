package com.escapethemansion.model.game.timer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {

    private Time time;

    @BeforeEach
    void setup() {
        this.time = new Time(30, 5);
    }

    @Test
    public void getSecond() {
        assertEquals(this.time.getSecond(), 30);
    }

    @Test
    public void getMinute() {
        assertEquals(this.time.getMinute(), 5);
    }

    @Test
    public void reduceTime() {
        assertTrue(this.time.reduceTime(true));

        this.time = new Time(0, 0);
        assertFalse(this.time.reduceTime(false));

        this.time = new Time(0, 5);
        assertTrue(this.time.reduceTime(false));

        this.time = new Time(10, 5);
        assertTrue(this.time.reduceTime(false));
    }
}
