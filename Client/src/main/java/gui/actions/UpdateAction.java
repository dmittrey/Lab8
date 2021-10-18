package gui.actions;

import gui.FrameHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpdateAction extends AbstractAction {

    private final FrameHandler frameHandler;

    public UpdateAction(FrameHandler aFrameHandler){
        frameHandler = aFrameHandler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameHandler.updateStudyGroup();
    }
}
