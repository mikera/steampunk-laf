package mikera.ui.steampunk;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

import mikera.gui.Draw;

public class SteamPunkBorder implements Border {
	public static final int BORDER_SIZE=8;

	public static SteamPunkBorder FILLED_BORDER=new SteamPunkBorder(true);
	public static SteamPunkBorder UNFILLED_BORDER=new SteamPunkBorder(false);
	
	private boolean fill=false;
	
	public SteamPunkBorder() {
		super();
	}
	
	public SteamPunkBorder(boolean drawCentre) {
		super();
		fill=drawCentre;
	}
	
	public static final Insets INSETS=new Insets(BORDER_SIZE,BORDER_SIZE,BORDER_SIZE,BORDER_SIZE);
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		Draw.drawImageWithBorder(g, x, y, width, height, Images.BRASS_PANEL,BORDER_SIZE,fill);		

	}

	public Insets getBorderInsets(Component c) {
		return INSETS;
	}

	public boolean isBorderOpaque() {
		return false;
	}

}
