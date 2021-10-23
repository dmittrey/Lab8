package gui;

import utility.Response;

public class VisualModelAnimator {

    private final GraphicPanel visualPanel;

    public VisualModelAnimator(FrameHandler aFrameHandler, GraphicPanel aVisualPanel) {
        visualPanel = aVisualPanel;
    }

    public void animateShow(Response aResponse) {
        if (aResponse.getSetOfStudyGroups() != null) {
            visualPanel.downloadCollection(aResponse.getSetOfStudyGroups());
        }
    }
}