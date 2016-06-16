package pl.shatan.radar.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.MainLoop;
import pl.shatan.radar.Radar;
import pl.shatan.radar.Unit;
import pl.shatan.radar.ui.listeners.ExitAppListener;
import pl.shatan.radar.ui.listeners.MapInputListener;
import pl.shatan.radar.ui.listeners.MenuHelpAppListener;

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
     * RadarPanel instance.
     */
    private RadarPanel radarPanel;

    private RadarTabbedPane radarTabbedPane;

    /**
     * Radar window width and height.
     */
    private int rWidth, rHeight;

    /**
     * Radar background.
     */
    private File radarBackground;

    /**
     * Instance of radar which stores all the info about units.
     */
    private Radar radar;

    public static void main(String[] args) {
        new RadarGUI();
    }

    RadarGUI()
    {
        // Sets Radar app window width and height.
        this.rHeight = 600;
        this.rWidth = 800;

        initUI();
    }

    private void initUI() {
        // Basic Frame settings.
        this.setTitle("Flight Control");
        this.setSize(this.rWidth, this.rHeight);
        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Centers the window on the screen.
        this.setLocationRelativeTo(null);

        // Makes app close when click the exit button.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Add menu toolbar to the window.
        this.createMenuToolbar();

        // Lets register Font Awesome to be able to place flighter-jet and BE AWESOMEEEEEEEEE. :D
        this.registerFontAwesome();

        // Adds radar with basic units.
        radarSetup();
        this.radarPanel = new RadarPanel(this.radar);
        this.add(radarPanel, BorderLayout.CENTER);

        this.radarTabbedPane = new RadarTabbedPane(this);
        this.add(radarTabbedPane, BorderLayout.EAST);
        radarTabbedPane.setMinimumSize(new Dimension(400, 200));

        // Draw loop.
        this.createDrawLoop();

        // Make the frame visible.
        this.setVisible(true);
    }

    private void createDrawLoop()
    {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
        executor.scheduleAtFixedRate(new MainLoop(this), 0, 20, TimeUnit.MILLISECONDS);
    }

    private void radarSetup() {
        this.radar = new Radar();

        AirUnit airplane = new AirUnit();
        this.radar.addUnit(airplane);

        AirUnit airplane2 = new AirUnit(100, 300, 0);
        this.radar.addUnit(airplane2);

        AirUnit airplane3 = new AirUnit(400, 300, 0);
        airplane3.setDirection(90);
        this.radar.addUnit(airplane3);
    }

    private void createMenuToolbar() {
        this.menuBar = new JMenuBar();

        // File menu tab settings.
        this.fileMenu = new JMenu("File");
        this.fileMenu.setMnemonic(KeyEvent.VK_F);

        this.map = new JMenuItem("Load Map");
        MapInputListener mapInputListener = new MapInputListener(this, this.map);
        this.map.addActionListener(mapInputListener);


        this.exit = new JMenuItem("Exit");
        this.exit.setMnemonic(KeyEvent.VK_E);
        this.exit.setToolTipText("Exit application");
        this.exit.addActionListener(new ExitAppListener());

        // About menu tab settings.
        this.helpMenu = new JMenu("Help");
        this.helpMenu.setMnemonic(KeyEvent.VK_H);

        this.about = new JMenuItem("About");
        this.about.setMnemonic(KeyEvent.VK_A);
        MenuHelpAppListener menuHelpAppListener = new MenuHelpAppListener(this, this.about);
        this.about.addActionListener(menuHelpAppListener);

        // Actually registers the menu tabs and items.
        this.fileMenu.add(this.map);
        this.fileMenu.add(this.exit);
        this.helpMenu.add(this.about);
        this.menuBar.add(this.fileMenu);
        this.menuBar.add(this.helpMenu);

        // Registers MenuBar.
        this.setJMenuBar(this.menuBar);
    }

    private void registerFontAwesome() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fontawesome-webfont.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }
    }
    public File getRadarBackground() {
        return this.radarBackground;
    }

    public void setRadarBackground(File map) {
        this.radarBackground = map;
        try {
            BufferedImage image = ImageIO.read(this.radarBackground);
            this.getRadarPanel().setBackgroundImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RadarPanel getRadarPanel() {
        return this.radarPanel;
    }

    public Radar getRadarInstance()
    {
        return this.radar;
    }

    public ArrayList<Unit> getRadarUnits()
    {
        return this.getRadarInstance().getUnits();
    }
}
