package gui;

import utility.Response;

import java.awt.*;

public class VisualModelAnimator {

    private final FrameHandler frameHandler;
    private final GraphicPanel visualPanel;

    public VisualModelAnimator(FrameHandler aFrameHandler, GraphicPanel aVisualPanel) {
        frameHandler = aFrameHandler;
        visualPanel = aVisualPanel;
    }

    public void draw(Canvas canvas) {
        Graphics gc = canvas.getGraphics();
        gc.drawLine(150, 150, 300, 300);
    }

    public void animateShow(Response aResponse) {
        if (aResponse.getSetOfStudyGroups() != null) {
            visualPanel.downloadCollection(aResponse.getSetOfStudyGroups());
        }
    }
}
