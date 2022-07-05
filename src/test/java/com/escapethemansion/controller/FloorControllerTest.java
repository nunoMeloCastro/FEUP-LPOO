package com.escapethemansion.controller;

import com.escapethemansion.controller.game.FloorController;
import com.escapethemansion.gui.LanternaGUI;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class FloorControllerTest {

    private FloorController floorController;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        Floor floor = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        LanternaGUI gui = new LanternaGUI(40, 30);
        this.floorController = new FloorController(floor);
    }

    @Test
    void getPlayerController() throws IOException, URISyntaxException, FontFormatException {
        Floor f = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        LanternaGUI g = new LanternaGUI(40, 30);
        FloorController fc = new FloorController(f);

        assertEquals(fc.getPlayerController(), this.floorController.getPlayerController());
    }

    @Test
    void getGhostController() throws IOException, URISyntaxException, FontFormatException {
        Floor f = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        LanternaGUI g = new LanternaGUI(40, 30);
        FloorController fc = new FloorController(f);

        assertEquals(fc.getGhostController(), this.floorController.getGhostController());
    }
}
