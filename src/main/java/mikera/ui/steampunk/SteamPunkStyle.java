package mikera.ui.steampunk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.ColorType;
import javax.swing.plaf.synth.Region;
import javax.swing.plaf.synth.SynthContext;
import javax.swing.plaf.synth.SynthGraphicsUtils;
import javax.swing.plaf.synth.SynthPainter;
import javax.swing.plaf.synth.SynthStyle;

import mikera.gui.BufferedImageIcon;
import mikera.util.Resource;

public class SteamPunkStyle extends SynthStyle {

	private static final int BASE_INSET=6;
	
	public static Font FONT;
	public static Font LARGE_FONT;
	public static Font HUGE_FONT;
	
	public static Insets ZERO_INSETS=new Insets(0,0,0,0);
	public static Insets NORMAL_INSETS=new Insets(6,6,6,6);
	
	public static SynthPainter PAINTER=new SteamPunkPainter();
	
	public static SynthGraphicsUtils UTILS=new SteamPunkGraphicsUtils();
	
	public static final Color GOLD_COLOUR=new Color(200,180,0);
	public static final Color COLOUR_GOLD_TEXT=GOLD_COLOUR;
	public static final Color COLOUR_DISABLED_TEXT = new Color(128,128,128);
	
	@Override
	protected Color getColorForState(SynthContext context, ColorType type) {
		if (type==ColorType.FOREGROUND) return Color.LIGHT_GRAY;
		if (type==ColorType.BACKGROUND) return Color.DARK_GRAY;
		if (type==ColorType.FOCUS) return Color.WHITE;
		if (type==ColorType.TEXT_FOREGROUND) {
			return getForegroundColour(context);
		}
		if (type==ColorType.TEXT_BACKGROUND) return Color.WHITE;
		return Color.GREEN;
	}
	
	public Color getForegroundColour(SynthContext context) {
		Region region=context.getRegion();
		if (	(region==Region.LABEL)
				||(region==Region.CHECK_BOX)
				||(region==Region.RADIO_BUTTON)) {
			JComponent c= context.getComponent();
			if (!c.isEnabled()) return COLOUR_DISABLED_TEXT;
			return COLOUR_GOLD_TEXT;
		}
		return Color.BLACK;
		
	}
	
	@Override
	public SynthPainter getPainter(SynthContext context) {
		return PAINTER;
	}
	
	private static Insets setInsets(Insets dest, Insets src) {
		if (dest==null) return new Insets(src.top, src.left, src.bottom,src.right);
		dest.top=src.top;
		dest.left=src.left;
		dest.right=src.right;
		dest.bottom=src.bottom;
		return dest;
	}
	
	@Override
	public Insets getInsets(SynthContext context, Insets insets) {
		Region region=context.getRegion();
//		if (insets!=null) {
//			insets.set(INSETS.top, INSETS.left, INSETS.bottom, INSETS.right);
//			return insets;
//		} 
//		if (
//			(region ==Region.BUTTON)
//			||(region ==Region.TEXT_FIELD)
//			||(region ==Region.TEXT_AREA)
//			||(region ==Region.TEXT_PANE)
//			||(region ==Region.LABEL)
//			||(region ==Region.MENU)
//			||(region ==Region.MENU_ITEM)
//			||(region ==Region.TOOL_TIP)
//		) {
//			return setInsets(insets,NORMAL_INSETS);
//		} else if (
//			(region==Region.PANEL)) {
//			return setInsets(insets,ZERO_INSETS);
//		}
		if (region==Region.TABBED_PANE_TAB) {
			return setInsets(insets,NORMAL_INSETS);
		}
		
		return super.getInsets(context, insets);
	}
	
	@Override public boolean isOpaque(SynthContext context) {
		return false;
	}

	@Override
	protected Font getFontForState(SynthContext context) {
		return FONT;
	}
	
	@Override
	public void installDefaults(SynthContext context) {
		super.installDefaults(context);
		
		// Region region=context.getRegion();
		JComponent c=context.getComponent();
		c.setForeground(getColorForState(context,ColorType.TEXT_FOREGROUND));
		
		
		// border for different components
		if (c instanceof JButton) {
			c.setBorder(new EmptyBorder(BASE_INSET,BASE_INSET,BASE_INSET,BASE_INSET));
		}
		
		if (c instanceof JCheckBox) {
			JCheckBox cb=(JCheckBox) c;
			setBitsIcons(cb,128,0);
			cb.setVerticalAlignment(SwingConstants.CENTER);
			cb.setHorizontalAlignment(SwingConstants.LEFT);
			cb.setHorizontalTextPosition(SwingConstants.TRAILING);
			cb.setVerticalTextPosition(SwingConstants.TOP);
		} else if (c instanceof JRadioButton) {
			JRadioButton rb=(JRadioButton) c;
			setBitsIcons(rb,192,0);
			rb.setVerticalAlignment(SwingConstants.CENTER);
			rb.setHorizontalAlignment(SwingConstants.LEFT);
			rb.setHorizontalTextPosition(SwingConstants.TRAILING);
			rb.setVerticalTextPosition(SwingConstants.TOP);
			
		} else if (c instanceof JSplitPane) {
			JSplitPane splitPane=(JSplitPane)c;
			splitPane.setDividerSize(14);
		}
		c.setOpaque(false);
		
		if ((c instanceof JTextArea)) {
			JTextArea ta=(JTextArea)c;
			ta.setLineWrap(true);
			ta.setWrapStyleWord(true);
		}
	}
	
	private void setBitsIcons(AbstractButton c, int x,int y) {
		c.setIcon(new BufferedImageIcon(Images.BITS_NORMAL,x+32,y,32,32,16,16));
		c.setSelectedIcon(new BufferedImageIcon(Images.BITS_NORMAL,x,y,32,32,16,16));
		c.setRolloverIcon(new BufferedImageIcon(Images.BITS_HIGHLIGHT,x+32,y,32,32,16,16));
		c.setRolloverSelectedIcon(new BufferedImageIcon(Images.BITS_HIGHLIGHT,x,y,32,32,16,16));
		c.setPressedIcon(new BufferedImageIcon(Images.BITS_PRESSED,x+32,y,32,32,16,16));
		c.setDisabledIcon(new BufferedImageIcon(Images.BITS_NORMAL,x+32,y+32,32,32,16,16));
		c.setDisabledSelectedIcon(new BufferedImageIcon(Images.BITS_NORMAL,x,y+32,32,32,16,16));
		
	}

	static {
		try {
			FONT=Font.createFont(Font.TRUETYPE_FONT, Resource.getResourceAsStream("fonts/GenR102.TTF"));
			FONT=FONT.deriveFont(Font.BOLD,15.0f);
			LARGE_FONT=FONT.deriveFont(Font.BOLD,22.0f);
			HUGE_FONT=FONT.deriveFont(Font.BOLD,40.0f);
		} catch (Throwable e) {
			FONT=null;
			e.printStackTrace();
		}
	}

}
