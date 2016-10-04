package mikera.ui.steampunk;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

import mikera.gui.Draw;

public class PanelBorder implements Border {
	public static final int BORDER_SIZE=6;
	
	public static PanelBorder FILLED_BORDER=new PanelBorder(true);
	public static PanelBorder UNFILLED_BORDER=new PanelBorder(false);
	
	private boolean fill=false;
	
	public PanelBorder() {
		super();
	}
	
	public PanelBorder(boolean drawCentre) {
		super();
		fill=drawCentre;
	}
	
	public static final Insets INSETS=new Insets(BORDER_SIZE,BORDER_SIZE,BORDER_SIZE,BORDER_SIZE);
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		Draw.drawImageWithBorder(g, x, y, width, height, Images.PLATE,BORDER_SIZE,fill);		

	}

	@Override
	public Insets getBorderInsets(Component c) {
		return INSETS;
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

}
