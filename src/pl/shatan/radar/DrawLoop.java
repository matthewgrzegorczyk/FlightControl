package pl.shatan.radar;

import javax.swing.*;

public class DrawLoop implements Runnable
{
	private JFrame parent;

	public DrawLoop(JFrame parent) {
		this.parent = parent;
	}

	public void run()
	{
		parent.repaint();
	}
}