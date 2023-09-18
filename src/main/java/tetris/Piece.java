package tetris;

import java.util.Arrays;
import java.util.List;

public class Piece {
    private int distance;
    private List<Side> sides;
    private Figure figure;
    private int x;
    private int y;
    public Piece(int distance, Side... sides) {
        this.distance = distance;
        this.sides = Arrays.asList(sides);
    }
    public void setFigure(Figure parent) {
        this.figure = parent;
        int dx = 0;
        int dy = 0;
        for (Side s : sides) {
            dx += distance * s.getX();
            dy += distance * s.getY();
        }
        x = parent.getX() + dx;
        y = parent.getY() + dy;
    }

    public void setSides(Side... sides) {
        this.sides = Arrays.asList(sides);
        int dx = 0;
        int dy = 0;
        for (Side s : sides) {
            dx += distance * s.getX();
            dy += distance * s.getY();
        }
        x = figure.getX() + dx;
        y = figure.getY() + dy;
    }
    public Piece copy() {
        return new Piece(distance, sides.toArray(new Side[0]));
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public List<Side> getSides() {
        return sides;
    }
}
