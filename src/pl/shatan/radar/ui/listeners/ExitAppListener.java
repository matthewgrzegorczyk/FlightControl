package pl.shatan.radar.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitAppListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }
}
