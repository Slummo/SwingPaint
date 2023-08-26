    package application;

    import javax.swing.*;

    public class MainFrame extends JFrame {
        private DrawPanel drawPanel;

        public MainFrame(String title, int w, int h) {
            super(title);
            setSize(w, h);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            init();
            setVisible(true);
        }

        private void init() {
            drawPanel = new DrawPanel();
            add(drawPanel);

            setJMenuBar(new MenuBar(drawPanel));
        }

        public static void main(String[] args) {
            new MainFrame("PaintSwing", 800, 600);
        }
    }
