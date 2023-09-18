package tetris;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Figure {
    private int x;
    private int y;
    private Color color;
    private List<Piece> pieces;
    public Figure(Color color, Piece... pieces) {
        this.color = color;
        this.pieces = new ArrayList<>(Arrays.asList(pieces));
        for (Piece piece : this.pieces)
            piece.setFigure(this);
    }
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        pieces.forEach(p -> {
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
        });
    }
    public void move(Side side) {
        move(side.getX(), side.getY());
    }
    public void draw(GraphicsContext g) {
        g.setFill(color);
        pieces.forEach(p -> g.fillRect(p.getX() * Tetris.TILE_SIZE, p.getY() * Tetris.TILE_SIZE, Tetris.TILE_SIZE, Tetris.TILE_SIZE));
    }
    public void rotateBack() {
        pieces.forEach(p -> p.setSides(p.getSides().stream().map(Side::prev).collect(Collectors.toList()).toArray(new Side[0])));
    }
    public void rotate() {
        pieces.forEach(p -> p.setSides(p.getSides().stream().map(Side::next).collect(Collectors.toList()).toArray(new Side[0])));
    }
    public void detach(int x, int y) {
        pieces.removeIf(p -> p.getX() == x && p.getY() == y);
    }
    public Figure copy() {
        return new Figure(color, pieces.stream().map(Piece::copy).collect(Collectors.toList()).toArray(new Piece[0]));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
}
