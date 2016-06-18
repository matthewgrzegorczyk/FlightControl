package pl.shatan.radar;

import pl.shatan.radar.ui.RadarGUI;

import javax.swing.*;

public class MainLoop implements Runnable
{
	private JFrame parent;

	public MainLoop(JFrame parent)
	{
		this.parent = parent;
	}

	public void run()
	{
		this.parent.repaint();
		RadarGUI radarGUI = (RadarGUI) parent;
		radarGUI.getRadarTabbedPane().updateSelectedUnitInfo();
	}
}