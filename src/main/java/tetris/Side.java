package tetris;

public enum Side {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);
    private int x;
    private int y;
    Side(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Side prev() {
        int prev = ordinal() - 1;
        if (prev == -1) {
            prev = Side.values().length - 1;
        }
        return Side.values()[prev];
    }
    public Side next() {
        int next = ordinal() + 1;
        if (next == Side.values().length) {
            next = 0;
        }
        return Side.values()[next];
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
