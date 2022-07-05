package com.escapethemansion.model.game.timer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloorTimerTest {

    private FloorTimer floorTimer;

    @BeforeEach
    void setup() {
        this.floorTimer = new FloorTimer(5, 30);
    }

    @Test
    void timeIsUp(){
        this.floorTimer = new FloorTimer(0, 0);
        assertTrue(this.floorTimer.timeIsUp());
    }

    @Test
    void pauseTimer(){
        this.floorTimer = new FloorTimer(5, 30);
        this.floorTimer.pauseTimer();
        assertTrue(this.floorTimer.isPaused());

        this.floorTimer = new FloorTimer(5, 30);
        this.floorTimer.resumeTimer();
        assertFalse(this.floorTimer.isPaused());
    }

    @Test
    void getTime(){
        assertEquals(this.floorTimer.getTime(), String.format("%02d:%02d", 5, 30));
    }
}
