package mikera.ui.steampunk;

import java.awt.image.BufferedImage;
import mikera.image.generation.ImageFilters;
import mikera.image.generation.ImageUtils;
import mikera.image.generation.Op;

public class Images {
	public static BufferedImage BRASS_PANEL = null;
	public static BufferedImage PLATE = null;
	public static BufferedImage BUTTON_NORMAL=null;
	public static BufferedImage BUTTON_HIGHLIGHT=null;
	public static BufferedImage BUTTON_PRESSED=null;
	public static BufferedImage BUTTON_DISABLED=null;
	public static BufferedImage BITS_NORMAL=null;
	public static BufferedImage BITS_HIGHLIGHT=null;
	public static BufferedImage BITS_PRESSED=null;
	public static BufferedImage WOOD=null;
	
	// all intended to be 128*128 images
	
	static  {
		try {
			BUTTON_NORMAL=ImageUtils.getImage("images/button-normal.png");
			BUTTON_HIGHLIGHT=ImageUtils.getImage("images/button-highlight.png");
			BUTTON_PRESSED=ImageUtils.getImage("images/button-pressed.png");
			BUTTON_DISABLED=Op.apply(BUTTON_NORMAL, new ImageFilters.GreyFilter());
			BITS_NORMAL=ImageUtils.getImage("images/bits-normal.png");
			BITS_HIGHLIGHT=ImageUtils.getImage("images/bits-highlight.png");
			BITS_PRESSED=ImageUtils.getImage("images/bits-pressed.png");
			WOOD=ImageUtils.getImage("images/wood.png");
			BRASS_PANEL=ImageUtils.getImage("images/panel.png");
			PLATE=ImageUtils.getImage("images/plate.png");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
