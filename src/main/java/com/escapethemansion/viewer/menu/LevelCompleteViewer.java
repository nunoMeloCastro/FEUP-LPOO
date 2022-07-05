package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.menu.LevelComplete;
import com.escapethemansion.model.menu.Pause;
import com.escapethemansion.viewer.Viewer;

public class LevelCompleteViewer extends Viewer<LevelComplete> {
    public LevelCompleteViewer(LevelComplete levelComplete) {
        super(levelComplete);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(15, 5), "level complete", "#FFFFFF");

        //draw total points

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(7 + 20*i, 20),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#32DB3E" : "#FFFFFF");
    }
}
