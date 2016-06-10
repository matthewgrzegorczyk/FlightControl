package pl.shatan.radar.surface;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BasicEx extends JFrame {

    public BasicEx() {
        initUI();
    }

    private void initUI() {
        // Adds the Radar onto the frame.
        this.add(new Surface());
        JFileChooser mapInput = new JFileChooser();
        mapInput.showOpenDialog(this);
        System.out.println(mapInput.getSelectedFile());

        createMenuBar();
        this.setTitle("Flight Control");
        setSize(800, 600);

        // Centers the window on the screen.
        setLocationRelativeTo(null);

        // Makes app close when click the exit button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenuBar() {
    }

    private void createButtons() {
        JButton button = new JButton("Start/Stop");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BasicEx ex = new BasicEx();
                ex.setVisible(true);
            }
        });
    }
}