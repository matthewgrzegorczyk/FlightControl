package pl.shatan.radar;

import javax.swing.*;

public class MainLoop implements Runnable
{
	private JFrame parent;

	public MainLoop(JFrame parent) {
		this.parent = parent;
	}

	public void run()
	{
		this.parent.repaint();
	}
}