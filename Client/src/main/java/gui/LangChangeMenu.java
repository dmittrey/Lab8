package gui;

import gui.logining.LoginController;

import javax.swing.*;
import java.util.Locale;

public class LangChangeMenu extends JPopupMenu {

    public LangChangeMenu(LoginController loginController) {

        JMenuItem enLang = new JMenuItem("English(AU)");
        JMenuItem lvLang = new JMenuItem("Latvian(LV)");
        JMenuItem ruLang = new JMenuItem("Russian(RU)");
        JMenuItem skLang = new JMenuItem("Slovak(SK)");

        add(enLang);
        add(lvLang);
        add(ruLang);
        add(skLang);

        enLang.addActionListener(e -> loginController.notifySwitchLanguage(new Locale("en", "AU")));
        lvLang.addActionListener(e -> loginController.notifySwitchLanguage(new Locale("lv", "LV")));
        ruLang.addActionListener(e -> loginController.notifySwitchLanguage(new Locale("ru", "RU")));
        skLang.addActionListener(e -> loginController.notifySwitchLanguage(new Locale("sk", "SK")));
    }
}