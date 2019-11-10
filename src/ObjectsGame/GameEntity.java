package ObjectsGame;

import java.awt.*;

public abstract class GameEntity {
    protected double x;
    protected double y;
    protected Image img;

    abstract public void update();
    abstract public void render(Graphics2D g2d);
}
