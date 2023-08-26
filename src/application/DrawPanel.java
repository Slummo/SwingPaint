package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class DrawPanel extends JPanel {
    private final ArrayList<ArrayList<PaintPoint>> lineSegments;
    private ArrayList<PaintPoint> currentSegment;
    private int currentStrokeWidth;
    private Color currentStrokeColor;

    public DrawPanel() {
        lineSegments = new ArrayList<>();
        currentSegment = new ArrayList<>();
        currentStrokeWidth = 5;
        currentStrokeColor = Color.BLACK;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentSegment = new ArrayList<>();
                currentSegment.add(new PaintPoint(e.getPoint(), currentStrokeWidth, currentStrokeColor));
                lineSegments.add(currentSegment);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentSegment.add(new PaintPoint(e.getPoint(), currentStrokeWidth, currentStrokeColor));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (ArrayList<PaintPoint> segment : lineSegments) {
            g2d.setStroke(new BasicStroke(segment.get(0).getWidth()));
            g2d.setColor(segment.get(0).getColor());
            if (segment.size() >= 2) {
                Point prevPoint = segment.get(0);
                for (int i = 1; i < segment.size(); i++) {
                    Point point = segment.get(i);
                    g2d.drawLine(prevPoint.x, prevPoint.y, point.x, point.y);
                    prevPoint = point;
                }
            }
        }
    }

    public int getCurrentStrokeWidth() {
        return currentStrokeWidth;
    }

    public void setCurrentStrokeWidth(int currentStrokeWidth) {
        this.currentStrokeWidth = currentStrokeWidth;
    }

    public void setCurrentStrokeColor(Color currentStrokeColor) {
        this.currentStrokeColor = currentStrokeColor;
    }

    public void clear() {
        lineSegments.clear();
        repaint();
    }
}
