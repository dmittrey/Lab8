package gui.actions;

import gui.FrameHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveAction extends AbstractAction {

    private final FrameHandler frameHandler;

    public RemoveAction(FrameHandler aFrameHandler){
        frameHandler = aFrameHandler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameHandler.removeStudyGroup();
    }
}
