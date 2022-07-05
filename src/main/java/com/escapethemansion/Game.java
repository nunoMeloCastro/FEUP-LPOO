package com.escapethemansion;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.gui.LanternaGUI;

import com.escapethemansion.model.game.Mansion;
import com.escapethemansion.state.MenuState;
import com.escapethemansion.state.State;
import com.escapethemansion.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;


public class Game {
    private State state;
    private LanternaGUI gui;
    private Mansion mansion;
    private int floorInd;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(45, 30);

        this.state = new MenuState(new Menu());
        this.mansion = new Mansion();
        this.floorInd = 0;
    }

    public LanternaGUI getGUI() {
        return this.gui;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Mansion getMansion() {
        return this.mansion;
    }

    public void setMansion(Mansion mansion) {
        this.mansion = mansion;
    }

    public int getFloorInd() {
        return this.floorInd;
    }

    public void setFloorInd(int floorInd) {
        this.floorInd = floorInd;
    }

    private void start() throws IOException {
        int FPS = 20;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) { }

        }

        gui.close();
    }


    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        System.out.println("Starting the Game!");

        new Game().start();
        exit(0);

//for mouse clicks
//        ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("MC: " + e.getX() + ", " + e.getY());
//            }
//        });

    }
}