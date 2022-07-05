package com.escapethemansion.model.game.floor;

import com.escapethemansion.model.game.element.*;
import com.escapethemansion.model.game.timer.FloorTimer;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class Floor {
    private Player player;
    private List<Wall> walls;
    private List<Ghost> ghosts;
    private List<Door> doors;
    private List<Key> keys;
    private List<Box> boxes;
    private List<Hole> holes;
    private String title;
    private final FloorTimer timer;
    private EndLevel levelEnd;
    private Weapon weapon;

    private final int width;
    private final int height;

    public Floor(int width, int height) {
        this.width = width;
        this.height = height;
        this.timer = new FloorTimer(5, 0);
        timer.startTimer();
    }

    public FloorTimer getTimer() {
        return timer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public EndLevel getLevelEnd() {
        return levelEnd;
    }

    public void setLevelEnd(EndLevel levelEnd) {
        this.levelEnd = levelEnd;
    }
    
    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Hole> getHoles() {
        return this.holes;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalNumKeys() {
        return player.getNumKeys() + keys.size();
    }

    public boolean collectPlayerKey(Key keyToCollect) {
        for(int i = 0; i < keys.size(); i++) {
            if(keys.get(i).equals(keyToCollect)) {
                keys.remove(i);
                player.addKey();

                if(!doors.isEmpty())
                    doors.remove(doors.size()-1);
                else
                    System.out.println("End of Level Doors!"); //TODO : add a next level door + level complete state

                return true;
            }
        }
        return  false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return width == floor.width && height == floor.height && Objects.equals(player, floor.player) && Objects.equals(walls, floor.walls) && Objects.equals(ghosts, floor.ghosts) && Objects.equals(keys, floor.keys) && Objects.equals(doors, floor.doors) && Objects.equals(title, floor.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, walls, ghosts, keys, doors, title, width, height);
    }

}
