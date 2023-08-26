package application;

import java.awt.*;

class PaintPoint extends Point {
    private final int width;
    private final Color color;

    public PaintPoint(Point point, int width, Color color) {
        super(point);
        this.width = width;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }
}