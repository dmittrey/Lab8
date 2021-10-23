package gui;

import data.StudyGroup;

import java.awt.*;

public class SGIcon {

    private StudyGroup studyGroup;
    private int size;
    private Color color;

    public SGIcon(StudyGroup aStudyGroup, int aSize, Color aColor) {
        studyGroup = aStudyGroup;
        size = aSize;
        color = aColor;
    }

    public void setSize(int aSize) {
        size = aSize;
    }

    public void setColor(Color aColor) {
        color = aColor;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public boolean include(int x1, int y1) {
        int x2 = studyGroup.getCoordinates().getX();
        int y2 = (int) Math.round(studyGroup.getCoordinates().getY());
        return !(getDistance(x1, y1, x2, y2) > size/5);
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))/5;
    }
}