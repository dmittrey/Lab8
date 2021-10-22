package gui;

import javax.swing.*;
import java.awt.*;

public class VisualModelAnimator {

    private final FrameHandler frameHandler;

    public VisualModelAnimator(FrameHandler aFrameHandler){
        frameHandler = aFrameHandler;
    }

    public void paintCoordinateAxes(JPanel jPanel) {
        Graphics g = jPanel.getGraphics();
        g.setColor(Color.BLACK);
        int width = jPanel.getSize().width;
        int height = jPanel.getSize().height;
        g.drawLine(0, height/2, width, height/2);
        g.drawLine(width/2, 0, width/2, height);
    }
}
