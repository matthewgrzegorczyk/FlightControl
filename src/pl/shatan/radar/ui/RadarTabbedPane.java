package pl.shatan.radar.ui;

import pl.shatan.radar.ui.listeners.AddAirUnitListener;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;

public class RadarTabbedPane extends JTabbedPane {
    private RadarGUI radarFrame;
    private JPanel groundUnitsPanel;
    private JPanel airUnitsPanel;
    private JPanel unitInfoPanel;

    private JTextField airUnitX;
    private JTextField airUnitY;
    private JTextField airUnitZ;
    private JTextField airUnitSpeed;
    private JTextField airUnitDirection;
    private JButton addAirUnitButton;

    private JTextField groundUnitX;
    private JTextField groundUnitY;
    private JTextField groundUnitZ;

    private JTextArea unitInfo;

    public RadarTabbedPane(RadarGUI frame)
    {
        this.radarFrame = frame;
        initUI();
    }

    public JPanel getGroundUnitsPanel() {
        return groundUnitsPanel;
    }

    public JPanel getAirUnitsPanel() {
        return airUnitsPanel;
    }

    public JPanel getUnitInfoPanel() {
        return unitInfoPanel;
    }

    public void initUI()
    {
        this.groundUnitsPanel = new JPanel();
        this.airUnitsPanel = new JPanel();
        this.unitInfoPanel = new JPanel();

        this.initAirUnitsPanel();
        this.initUnitInfoPanel();

        this.add("Air Units", this.airUnitsPanel);
        this.add("Ground Units", this.groundUnitsPanel);
        this.add("Unit Info", this.unitInfoPanel);
    }

    private void initAirUnitsPanel()
    {
//        this.airUnitsPanel.setLayout(new GridLayout(10, 15, 0, 30));
        this.airUnitX = new JTextField("X", 1);
        this.airUnitY = new JTextField("Y", 1);
        this.airUnitZ = new JTextField("Z", 1);

        this.airUnitsPanel.add(this.airUnitX);
        this.airUnitsPanel.add(this.airUnitY);
        this.airUnitsPanel.add(this.airUnitZ);

        // Add Air Unit setup and register listener.
        this.addAirUnitButton = new JButton("Add Unit");
        this.addAirUnitButton.addActionListener(new AddAirUnitListener(this.radarFrame, this.addAirUnitButton));

        this.airUnitsPanel.add(addAirUnitButton);
    }
    private void initGroundUnitsPanel()
    {


    }

    private void initUnitInfoPanel()
    {
        this.unitInfo = new JTextArea(8, 25);
        this.unitInfo.setText(radarFrame.getName());
        this.unitInfoPanel.add(this.unitInfo);
    }

}
