package gui.components;


import gui.factory.FactoryPanels;

import javax.swing.*;
import java.awt.*;

public class ItemListPanel extends JPanel {
    private String buttonSearchPK, buttonDownloadPK;

    public ItemListPanel(String buttonSearchPropertyKey, String buttonDownloadPropertyKey) {
        this.buttonSearchPK = buttonSearchPropertyKey;
        this.buttonDownloadPK = buttonDownloadPropertyKey;
        this.setLayout(new BorderLayout());
        addComponents();
    }

    private void addComponents() {
        JPanel topPanel = FactoryPanels.getTopSearchPanel();
        topPanel.add(new LangButton(buttonSearchPK));
        this.add(topPanel, BorderLayout.NORTH);
        this.add(new LangButton(buttonDownloadPK), BorderLayout.SOUTH);


    }


}
