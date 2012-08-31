package mikera.ui.steampunk;

import java.awt.Graphics;

import javax.swing.JPanel;

import mikera.ui.Draw;

@SuppressWarnings("serial")
public class PlatePanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		Draw.drawImageWithBorder(g, 0, 0, getWidth(), getHeight(), Images.PLATE,8,true);		
	}
}
