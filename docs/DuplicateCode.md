
### Duplicate code

#### Problem
Four fragments of code for drawing elements look almost identical, it only changes the object class (`PlayerViewer`,
`GhostViewer`, `WallViewer`, `KeyViewer`).

  ```java
  public void drawPlayer(Player player) {
      tg.setForegroundColor(TextColor.Factory.fromString(player.getColor()));
      tg.enableModifiers(SGR.BOLD);
      tg.putString(new TerminalPosition(player.getPosition().getX(), player.getPosition().getY()), player.getAppearance());
  }

  public void drawWall(Wall wall) {
      tg.setForegroundColor(TextColor.Factory.fromString(wall.getColor()));
      tg.enableModifiers(SGR.BOLD);
      tg.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), wall.getAppearance());
  }

  public void drawGhost(Ghost ghost) {
      tg.setForegroundColor(TextColor.Factory.fromString(ghost.getColor()));
      tg.enableModifiers(SGR.BOLD);
      tg.putString(new TerminalPosition(ghost.getPosition().getX(), ghost.getPosition().getY()), ghost.getAppearance());
  }

  public void drawKey(Key key) {
      tg.setForegroundColor(TextColor.Factory.fromString(key.getColor()));
      tg.enableModifiers(SGR.BOLD);
      tg.putString(new TerminalPosition(key.getPosition().getX(), key.getPosition().getY()), key.getAppearance());
  }
  ```

#### Solution
Since all of these classes (`Ghost`, `Player`, `Wall`, `Key`) extend the class `Element`, it is possible to reduce these 4
methods into a single generic method that extends the class `Element`.

  ```java
  public <T extends Element> void drawElement(T element) {
    tg.setForegroundColor(TextColor.Factory.fromString(element.getColor()));
    tg.enableModifiers(SGR.BOLD);
    tg.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), element.getAppearance());
  }
  ```