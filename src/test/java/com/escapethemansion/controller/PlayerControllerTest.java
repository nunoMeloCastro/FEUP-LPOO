package com.escapethemansion.controller;

import com.escapethemansion.controller.game.PlayerController;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Ghost;
import com.escapethemansion.model.game.element.Player;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

// TODO : CORRIGIR OS TESTES
public class PlayerControllerTest {

    private PlayerController playerController;

    @BeforeEach
    void setup() throws IOException {
        Floor floor = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        this.playerController = new PlayerController(floor);
    }

    @Test
    void getFloor() throws IOException {
        Floor test = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        assertEquals(this.playerController.getModel(), test);
    }

    @Test
    void getPlayer(){
        assertEquals(this.playerController.getModel().getPlayer(), new Player(new Position(18,21)));
    }

    @Test
    void setPlayer(){
        this.playerController.getModel().getPlayer().setPosition(new Position(20,13));
        assertEquals(this.playerController.getModel().getPlayer(), new Player(new Position(20,13)));
    }

    @Test
    void canPlayerMove() {
        assertFalse(this.playerController.canElementMove(new Position(18,22)));
        assertTrue(this.playerController.canElementMove(new Position(18,20)));
    }

}
