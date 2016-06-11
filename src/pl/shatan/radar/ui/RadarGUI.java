package pl.shatan.radar.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pl.shatan.radar.ui.listeners.MapInputListener;

/**
 * Radar`s MainFrame.
 */
public class RadarGUI extends JFrame {
    /**
     * Map file input.
     */
    private JFileChooser mapInput;

    /**
     * Menu toolbar.
     */
    private JMenuBar menuBar;

    /**
     * Menus
     */
    private JMenu fileMenu, helpMenu;
    /**
     * Menu items.
     */
    private JMenuItem exit, about, map;
    /**
     * Radar window width and height.
     */
    private int rWidth, rHeight;

    /**
     * Radar background.
     */
    private File radarBackground;

    RadarGUI()
    {
        // Sets Radar app window width and height.
        this.rHeight = 600;
        this.rWidth = 800;

        initUI();
    }

    private void initUI() {
        this.setTitle("Flight Control");
        this.setSize(this.rWidth, this.rHeight);

        // Centers the window on the screen.
        this.setLocationRelativeTo(null);

        // Makes app close when click the exit button.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Add menu toolbar to the window.
        this.createMenuToolbar();

        ScheduledThreadPoolExecutor executor;
        executor = new ScheduledThreadPoolExecutor(5);

        // executor.scheduleAtFixedRate(new MyRepaint(frame), 0L, 20L, TimeUnit.MILLISECONDS);

        // Make the frame visible.
        this.setVisible(true);
    }

    private void createMenuToolbar() {
        this.menuBar = new JMenuBar();

        // File menu tab settings.
        this.fileMenu = new JMenu("File");
        this.fileMenu.setMnemonic(KeyEvent.VK_F);

        this.map = new JMenuItem("Load Map");
        MapInputListener mapInputListener = new MapInputListener(this);
        this.map.addActionListener(mapInputListener);


        this.exit = new JMenuItem("Exit");
        this.exit.setMnemonic(KeyEvent.VK_E);
        this.exit.setToolTipText("Exit application");
        this.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        // About menu tab settings.
        this.helpMenu = new JMenu("Help");
        this.helpMenu.setMnemonic(KeyEvent.VK_A);

        this.about = new JMenuItem("About");

        // Actually registers the menu tabs and items.
        this.fileMenu.add(this.exit);
        this.helpMenu.add(this.about);
        this.menuBar.add(this.fileMenu);
        this.menuBar.add(this.helpMenu);

        // Registers MenuBar.
        this.setJMenuBar(this.menuBar);
    }

    public void setRadarBackground(File map) {
        this.radarBackground = map;
    }
}
