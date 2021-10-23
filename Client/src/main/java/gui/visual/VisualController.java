package gui.visual;

import Interfaces.Localizable;
import Interfaces.Relocatable;
import gui.FrameHandler;
import gui.VisualModelAnimator;
import utility.*;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Logger;

public class VisualController implements Relocatable, Localizable {

    private final VisualModel model;
    private final VisualModelAnimator visualModelAnimator;
    private final FrameHandler frameHandler;

    public VisualController(FrameHandler aFrameHandler) {
        frameHandler = aFrameHandler;
        model = new VisualModel(this, frameHandler);
        visualModelAnimator = new VisualModelAnimator(frameHandler, model.getVisualPanel());
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Study groups visual");
        setUsername();
        jFrame.setContentPane(model.getMainPanel());
        jFrame.setSize(1080, 560);
        setLocation(jFrame);
        jFrame.revalidate();
    }

    public VisualModelAnimator getVisualModelAnimator() {
        return visualModelAnimator;
    }

    public void switchLanguage(Locale locale) {
        model.switchLanguage(locale);
    }

    public void notifySwitchLanguage(Locale locale) {
        frameHandler.switchLanguage(locale);
    }

    private void setUsername() {
        String username = RequestHandler.getInstance().getSession().getName();
        model.setUsername(username);
    }
}