package geekbrains.java1.lesson7.noughts_and_crosses;

import javax.swing.*;
import java.awt.*;

class Map extends JPanel {

    static final int GAME_MODE_HUMAN_VS_AI = 0;
    static final int GAME_MODE_HUMAN_VS_HUMAN = 1;
    private int mode;
    private int field_size_x;
    private int field_size_y;
    private int win_len;

    Map() {
        setBackground(Color.WHITE);
    }

    void startNewGame(int mode, int field_size_x, int field_size_y, int win_len) {
        System.out.println("mode = " + mode + " field_size = " + field_size_x + " win_len = " + win_len);
        this.mode = mode;
        this.field_size_x = field_size_x;
        this.field_size_y = field_size_y;
        this.win_len = win_len;
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = this.getWidth();
        int y = this.getHeight();
        g.setColor(Color.BLACK);
        for (int i = 1; i < field_size_x; i++) {
            g.drawLine(x / field_size_x * i, 5, x / field_size_x * i, x - 5);
            g.drawLine(5, y / field_size_y * i, y - 5, y / field_size_y * i);
        }
    }
}
