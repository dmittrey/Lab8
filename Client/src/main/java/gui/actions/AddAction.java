package gui.actions;

import gui.FrameHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddAction extends AbstractAction {

    private final FrameHandler frameHandler;

    public AddAction(FrameHandler aFrameHandler){
        frameHandler = aFrameHandler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameHandler.addStudyGroup();
    }
}
