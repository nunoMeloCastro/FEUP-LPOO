package com.escapethemansion.viewer.game;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.*;
import com.escapethemansion.model.game.element.component.*;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.timer.FloorTimer;
import com.escapethemansion.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Floor> {

    public GameViewer(Floor model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawText(new Position(12,3), getModel().getTitle(), "#FFFFFF");

        drawElements(gui, getModel().getWalls(), new ElementViewer<Wall>());
        drawElements(gui, getModel().getHoles(), new ElementViewer<Hole>());
        drawElements(gui, getModel().getBoxes(), new ElementViewer<Box>());
        drawElements(gui, getModel().getDoors(), new ElementViewer<Door>());
        drawElements(gui, getModel().getKeys(), new ElementViewer<Key>());
        drawElement(gui, getModel().getWeapon(), new ElementViewer<Weapon>());
        drawElement(gui, getModel().getPlayer(), new ElementViewer<Player>());

        if(getModel().getKeys().isEmpty())
            drawElement(gui, getModel().getLevelEnd(), new ElementViewer<EndLevel>());

        drawElements(gui, getModel().getGhosts(), new ElementViewer<Ghost>());

        drawPlayerComponent(gui, getModel().getPlayer().getLife(), new PlayerComponentViewer<Life>());
        drawPlayerComponent(gui, getModel().getPlayer().getFear(), new PlayerComponentViewer<Fear>());
        drawPlayerComponent(gui, getModel().getPlayer().getBattery(), new PlayerComponentViewer<Battery>());

        drawKeysCollected(gui);
        drawTimer(gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.drawElement(gui, element);
    }

    private <T extends PlayerComponent> void drawPlayerComponent(GUI gui,T playerComponent, PlayerComponentViewer<T> playerComponentViewer) {
        playerComponentViewer.drawPlayerComponent(gui, playerComponent);
    }

    private void drawTimer(GUI gui) {
        gui.drawText(new Position(26, 6), "timer: " + getModel().getTimer().getTime(), "#FFFFFF");
    }

    private void drawKeysCollected(GUI gui) {
        gui.drawText(new Position(1, 16), "keys collected: " + getModel().getPlayer().getNumKeys() + "/" + getModel().getTotalNumKeys(), "#72BB53");
    }
}
