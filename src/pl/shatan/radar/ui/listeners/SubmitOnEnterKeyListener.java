package pl.shatan.radar.ui.listeners;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ShataN_2 on 18/06/2016.
 */
public class SubmitOnEnterKeyListener implements KeyListener {
    private JTextField textField;
    private JButton button;

    public SubmitOnEnterKeyListener(JTextField textField, JButton associatedSubmitButton) {
        this.textField = textField;
        this.button = associatedSubmitButton;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == this.textField && e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.button.doClick();
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
