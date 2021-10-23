package gui;

import data.StudyGroup;
import gui.visual.VisualModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphicPanel extends JPanel {

    private final Set<StudyGroup> buffer;
    private final VisualModel visualModel;
    private final SGIconStorage sgIconStorage;

    public GraphicPanel(VisualModel aVisualModel) {
        buffer = new HashSet<>();
        visualModel = aVisualModel;
        sgIconStorage = new SGIconStorage();
    }

    public Set<SGIcon> getPaintedGroups() {
        return sgIconStorage.getStorage();
    }

    public void downloadCollection(Set<StudyGroup> newCollection) {

        buffer.removeAll(buffer.stream()
                .filter(sg -> !(newCollection.contains(sg)))
                .collect(Collectors.toSet()));
        sgIconStorage.getStorage().removeAll(sgIconStorage.getStorage().stream()
                .filter(pg -> !(buffer.contains(pg.getStudyGroup())))
                .collect(Collectors.toSet()));
        visualModel.getMainPanel().repaint();

        Set<StudyGroup> addedGroups = newCollection.stream()
                .filter(sg -> !(buffer.contains(sg)))
                .collect(Collectors.toSet());

        addedGroups.forEach(this::run);

        buffer.addAll(addedGroups);
    }

    @Override
    public void paintComponent(Graphics g) {

        class ArrowRight extends Path2D.Double {
            public ArrowRight(int width, int height) {
                moveTo(width - 16, height - 10);
                lineTo(width, height);
                lineTo(width - 16, height + 10);
            }
        }
        class ArrowTop extends Path2D.Double {
            public ArrowTop(int width, int height) {
                moveTo(width - 10, height + 16);
                lineTo(width, height);
                lineTo(width + 10, height + 16);
            }
        }

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int width = this.getSize().width;
        int height = this.getSize().height;
        g.drawLine(0, height / 2, width, height / 2);
        g2.draw(new ArrowRight(width, height / 2));
        g.drawLine(width / 2, 0, width / 2, height);
        g2.draw(new ArrowTop(width / 2, 0));
        sgIconStorage.getStorage().forEach(sgIcon -> {
            int size = sgIcon.getSize();
            int startX = width / 2 + sgIcon.getStudyGroup().getCoordinates().getX() - size;
            int startY = height / 2 + (int) Math.round(sgIcon.getStudyGroup().getCoordinates().getY()) - size;
            Color color = sgIcon.getColor();

            g2.setColor(Color.BLACK);
            g2.drawOval(startX, startY, size * 2, size * 2);
            g2.drawOval(startX + 2 * size / 3, startY, 2 * size / 3, 2 * size / 3);
            g2.drawOval(startX + 2 * size / 3, startY + 4 * size / 3, 2 * size / 3, 2 * size / 3);
            g2.drawOval(startX, startY + 2 * size / 3, 2 * size / 3, 2 * size / 3);
            g2.drawOval(startX + 4 * size / 3, startY + 2 * size / 3, 2 * size / 3, 2 * size / 3);


            int verticalFirstEyeStart = (startX + 2 * size / 3) + size / 6;
            int verticalSecondEyeStart = (startX + 2 * size / 3) + size / 3;
            int horizontalDownEyesLevel = (startY + 4 * size / 3) + size / 6;
            int horizontalUpEyesLevel = startY + size / 6;
            int eyesDiameter = size / 8;
            g2.setColor(color);

            g2.fillOval(verticalFirstEyeStart, horizontalUpEyesLevel, eyesDiameter, eyesDiameter);
            g2.fillOval(verticalSecondEyeStart, horizontalUpEyesLevel, eyesDiameter, eyesDiameter);

            g2.fillOval(verticalFirstEyeStart, horizontalDownEyesLevel, eyesDiameter, eyesDiameter);
            g2.fillOval(verticalSecondEyeStart, horizontalDownEyesLevel, eyesDiameter, eyesDiameter);

            g2.fillOval(startX + size / 6, startY + 2 * size / 3 + size / 6, eyesDiameter, eyesDiameter);
            g2.fillOval(startX + size / 3, startY + 2 * size / 3 + size / 6, eyesDiameter, eyesDiameter);

            g2.fillOval(startX + 4 * size / 3 + size / 6, startY + 2 * size / 3 + size / 6, eyesDiameter, eyesDiameter);
            g2.fillOval(startX + 4 * size / 3 + size / 3, startY + 2 * size / 3 + size / 6, eyesDiameter, eyesDiameter);
        });
    }

    public void run(StudyGroup studyGroup) {
        int maxValue = studyGroup.getStudentsCount() * 5;
        SGIcon sgIcon = sgIconStorage.createSGIcon(studyGroup, maxValue);
        for (int i = 0; i < maxValue; i++) {
            sgIcon.setSize(i);
            this.repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}