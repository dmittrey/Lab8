package gui;

import data.StudyGroup;

import java.util.Set;

public class SGIcon {

    private StudyGroup studyGroup;
    private int size;

    public SGIcon(StudyGroup aStudyGroup, int aSize) {
        studyGroup = aStudyGroup;
        size = aSize;
    }

    public void setStudyGroup(StudyGroup aStudyGroup) {
        studyGroup = aStudyGroup;
    }

    public void setSize(int aSize) {
        size = aSize;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public int getSize() {
        return size;
    }
}
