package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.menu.GameComplete;
import com.escapethemansion.model.menu.Options;
import com.escapethemansion.viewer.Viewer;

public class GameCompleteViewer  extends Viewer<GameComplete> {
    public GameCompleteViewer(GameComplete gameComplete) {
        super(gameComplete);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(13, 5), "game complete", "#FCA52B");
        gui.drawText(new Position(10, 9), "thank you for playing", "#FFFFFF");
        gui.drawText(new Position(11, 10), "escape the mansion!", "#FFFFFF");

        gui.drawText(new Position(11, 14), "Xfeup-lpoo-2021-g11", "#FFFFFF");
        gui.drawText(new Position(12, 16) , "ana matilde barra", "#FFFFFF");
        gui.drawText(new Position(14, 17) , "angela coelho", "#FFFFFF");
        gui.drawText(new Position(15, 18) , "nuno castro", "#FFFFFF");

        //total score of game

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            Position toDraw = new Position(13, 22 + 2 * i);

            gui.drawText(
                    toDraw,
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FCA52B" : "#FFFFFF");
        }
    }
}
