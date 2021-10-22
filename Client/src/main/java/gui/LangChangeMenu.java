package gui;

import Interfaces.Localizable;

import javax.swing.*;
import java.util.Locale;

public class LangChangeMenu extends JPopupMenu {

    public LangChangeMenu(Localizable controller) {

        JMenuItem enLang = new JMenuItem("English(AU)");
        JMenuItem lvLang = new JMenuItem("Latvian(LV)");
        JMenuItem ruLang = new JMenuItem("Russian(RU)");
        JMenuItem skLang = new JMenuItem("Slovak(SK)");

        add(enLang);
        add(lvLang);
        add(ruLang);
        add(skLang);

        enLang.addActionListener(e -> controller.notifySwitchLanguage(new Locale("en", "AU")));
        lvLang.addActionListener(e -> controller.notifySwitchLanguage(new Locale("lv", "LV")));
        ruLang.addActionListener(e -> controller.notifySwitchLanguage(new Locale("ru", "RU")));
        skLang.addActionListener(e -> controller.notifySwitchLanguage(new Locale("sk", "SK")));
    }
}