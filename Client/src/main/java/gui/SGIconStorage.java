package gui;

import data.StudyGroup;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SGIconStorage {

    private final HashSet<SGIcon> sgIcons;

    public SGIconStorage() {
        sgIcons = new HashSet<>();
    }

    public Set<SGIcon> getStorage() {
        return sgIcons;
    }

    public SGIcon createSGIcon(StudyGroup aStudyGroup, int aSize) {
        Color color = findColor(aStudyGroup);
        SGIcon newSGIcon = new SGIcon(aStudyGroup, aSize, color);
        sgIcons.add(newSGIcon);
        return newSGIcon;
    }

    public Color findColor(StudyGroup aStudyGroup) {
        SGIcon findResult = sgIcons.stream()
                .filter(sg -> sg.getStudyGroup().getAuthor().equals(aStudyGroup.getAuthor()))
                .findFirst()
                .orElse(null);
        if (findResult == null) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            return new Color(r, g, b);
        } else return findResult.getColor();
    }
}