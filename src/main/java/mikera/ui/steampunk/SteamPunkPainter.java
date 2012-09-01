package mikera.ui.steampunk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;
import javax.swing.plaf.synth.SynthConstants;
import javax.swing.plaf.synth.SynthContext;
import javax.swing.plaf.synth.SynthPainter;

import mikera.ui.Draw;
 
public class SteamPunkPainter extends SynthPainter {
	public static final Color MENU_COLOR = new Color(170,100,0);
	public static final Color MENU_ITEM_COLOR = new Color(190,120,20);
	public static final Color MENU_COLOR_HIGHLIGHT = new Color(255,250,100);
	public static final Color MENU_BORDER = Color.BLACK;
	
	public static final Color BRASS_COLOR=new Color(180,120,50);
	public static final Color BRASS_HIGHLIGHT=new Color(255,240,200);
	public static final Color BRASS_SHADOW=new Color(100,50,10);
	
	public static final boolean DEBUG=false;
	public static final boolean PAINT_PANEL_EDGES=DEBUG;


	@Override
	public void paintArrowButtonBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// TODO
	}
	
	@Override
	public void paintArrowButtonBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// TODO
	}
	
	@Override
	public void paintArrowButtonForeground(SynthContext context, Graphics g, int x, int y, int w, int h, int direction) {
		BufferedImage img=Images.BITS_NORMAL;
		if ((context.getComponentState()&SynthConstants.PRESSED)!=0) {
			img=Images.BITS_PRESSED;
		} else if ((context.getComponentState()&SynthConstants.MOUSE_OVER)!=0) {
			img=Images.BITS_HIGHLIGHT;
		}
		
		int sx=0;
		int sy=0;

		switch (direction) {
			case SwingConstants.SOUTH: sx=0; break;
			case SwingConstants.EAST: sx=32; break;
			case SwingConstants.WEST: sx=64; break;
			case SwingConstants.NORTH: sx=96; break;
		}
		
		g.drawImage(img, x, y, x+w, y+h, sx, sy, sx+32, sy+32, null);
	}
	
	// Painters methods
	@Override
	public void paintButtonBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawButton(context,g,x,y,w,h);
	}
	
	@Override
	public void paintButtonBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing, no special border painting
	}
	
	@Override
	public void paintCheckBoxBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
//		int CHECKBOXSIZE=16;
//		int cbx=x;
//		int cby=y+(h-CHECKBOXSIZE)/2;
//		
//		BufferedImage img=Images.BITS_NORMAL;
//		if ((context.getComponentState()&SynthConstants.PRESSED)!=0) {
//			img=Images.BITS_PRESSED;
//		} else if ((context.getComponentState()&SynthConstants.MOUSE_OVER)!=0) {
//			img=Images.BITS_HIGHLIGHT;
//		}
//		
//		int sx=((context.getComponentState()&SynthConstants.SELECTED)!=0)?128:160;
//		int sy=0;
//		
//		System.out.println(context.toString()+" pos "+x+","+y+" size "+w+","+h);
//		g.drawImage(img, cbx, cby, cbx+CHECKBOXSIZE, cby+CHECKBOXSIZE, sx, sy, sx+32, sy+32, null);
	}
	
	@Override
	public void paintCheckBoxBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	
	@Override
	public void paintCheckBoxMenuItemBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintCheckBoxMenuItemBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintColorChooserBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintColorChooserBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintComboBoxBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawBrassPanel(context,g,x,y,w,h);
	}
	
	@Override
	public void paintComboBoxBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintDesktopIconBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintDesktopIconBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintDesktopPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintDesktopPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	
	@Override
	public void paintEditorPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawWood(context,g, x, y, w, h);
	}
	
	@Override
	public void paintEditorPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintFileChooserBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawWood(context,g, x, y, w, h);
	}
	
	@Override
	public void paintFileChooserBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintFormattedTextFieldBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintFormattedTextFieldBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	

	@Override
	public void paintInternalFrameBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawWood(context,g, x, y, w, h);
	}
	
	@Override
	public void paintInternalFrameBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintInternalFrameTitlePaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawWood(context,g, x, y, w, h);
	}
	
	@Override
	public void paintInternalFrameTitlePaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	
	@Override
	public void paintLabelBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintLabelBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	
	@Override
	public void paintListBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintListBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}

	// Menus
	
	@Override
	public void paintMenuBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBackground(context,g,x,y,w,h);
	}
	
	@Override
	public void paintMenuBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuItemBorder(context,g,x,y,w,h);
	}

	@Override
	public void paintMenuBarBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBackground(context,g,x,y,w,h);
		// drawPlate(context,g,x,y,w,h);
	}
	
	@Override
	public void paintMenuBarBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBorder(context,g,x,y,w,h);
	}
	
	
	@Override
	public void paintMenuItemBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuItemBackground(context,g,x,y,w,h);
	}
	
	@Override
	public void paintMenuItemBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuItemBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintPopupMenuBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuItemBackground(context,g,x,y,w,h);
	}
	
	@Override
	public void paintPopupMenuBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuItemBorder(context,g,x,y,w,h);
	}
	

	// Option pane
	
	@Override
	public void paintOptionPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintOptionPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	// Panel
	
	@Override
	public void paintPanelBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintPanelBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		if (PAINT_PANEL_EDGES) {
			g.setColor(Color.RED);
			Draw.drawOutlineRect(g,x,y,w,h);
		}
	}

	// Password Field
	
	@Override
	public void paintPasswordFieldBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		paintTextFieldBackground(context,g,x,y,w,h);
	}
	
	@Override
	public void paintPasswordFieldBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	

	@Override
	public void paintProgressBarBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintProgressBarBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	
	@Override
	public void paintRadioButtonBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintRadioButtonBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	
	@Override
	public void paintRadioButtonMenuItemBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBackground(context,g,x,y,w,h);
	}
	
	@Override
	public void paintRadioButtonMenuItemBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBorder(context,g,x,y,w,h);
	}

	
	@Override
	public void paintRootPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawWood(context,g, x, y, w, h);
	}
	
	@Override
	public void paintRootPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintScrollBarBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawPlate(context,g,x,y,w,h);
	}
	
	@Override
	public void paintScrollBarBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}

	
	@Override
	public void paintScrollBarThumbBackground(SynthContext context, Graphics g, int x, int y, int w, int h, int orientation) {
		drawButton(context,g,x,y,w,h);
	}
	
	@Override
	public void paintScrollBarThumbBorder(SynthContext context, Graphics g, int x, int y, int w, int h, int orientation) {
		// Do nothing
	}
	
	@Override
	public void paintScrollBarTrackBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintScrollBarTrackBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintScrollPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintScrollPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintSeparatorBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawBrassPanel(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSeparatorBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintSliderBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSliderBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSliderThumbBackground(SynthContext context, Graphics g, int x, int y, int w, int h, int orientation) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSliderThumbBorder(SynthContext context, Graphics g, int x, int y, int w, int h, int orientation) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSliderTrackBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSliderTrackBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSpinnerBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSpinnerBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	
	@Override
	public void paintSplitPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintSplitPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override
	public void paintSplitPaneDividerBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawBrassPanel(context,g,x,y,w,h);
	}
	
	@Override
	public void paintSplitPaneDividerForeground(SynthContext context, Graphics g, int x, int y, int w, int h, int orientation) {
		// Do nothing	
	}
	
	@Override
	public void paintSplitPaneDragDivider(SynthContext context, Graphics g, int x, int y, int w, int h, int orientation) {
		drawBrassPanel(context,g,x,y,w,h);
	}
	
	@Override
	public void paintTabbedPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		//blank
	}
	
	@Override
	public void paintTabbedPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		//blank
	}
	
	@Override
	public void paintTabbedPaneContentBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawPlate(context,g,x,y,w,h);
	}
	
	@Override
	public void paintTabbedPaneContentBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override public void paintTabbedPaneTabAreaBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// invisible
	}
	
	@Override public void paintTabbedPaneTabAreaBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// invisible
	}
	
	@Override public void paintTabbedPaneTabBackground(SynthContext context, Graphics g, int x, int y, int w, int h, int tabIndex) {
		if ((context.getComponentState()&SynthConstants.SELECTED)!=0) {
			drawButton(context,g,x,y,w,h+10);
		} else {
			drawButton(context,g,x,y+3,w,h-3);
		}
	}
	
	@Override public void paintTabbedPaneTabBorder(SynthContext context, Graphics g, int x, int y, int w, int h, int tabIndex) {
		//drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintTableBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintTableBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintTableHeaderBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintTextAreaBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		//drawPlate(context,g,x,y,w,h);
	}
	
	@Override public void paintTextAreaBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override public void paintTextFieldBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		//drawPlate(context,g,x,y,w,h);
	}
	
	@Override public void paintTextFieldBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override public void paintTextPaneBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintTextPaneBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintToggleButtonBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintToggleButtonBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintToolBarBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintToolBarBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintToolBarContentBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintToolBarContentBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintToolBarDragWindowBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintToolBarDragWindowBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintToolTipBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBackground(context,g,x,y,w,h);
	}
	
	@Override public void paintToolTipBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawAnyMenuBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintTreeBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintTreeBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}
	
	@Override public void paintTreeCellBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognised(context,g,x,y,w,h);
	}
	
	@Override public void paintTreeCellBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		drawUnrecognisedBorder(context,g,x,y,w,h);
	}

	@Override public void paintViewportBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}
	
	@Override public void paintViewportBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}


	
	

	
	// Steampunk Painting methods
	
	public void drawWood(SynthContext context, Graphics g, int x, int y, int w, int h) {
		Draw.drawImageTiled(g, x, y, w, h, Images.WOOD);		
	}
	
	public void drawBrassPanel(SynthContext context, Graphics g, int x, int y, int w, int h) {
//		g.setColor(BRASS_COLOR);
//		g.fillRect(x+1, y+1, w-2,h-2);
//		g.setColor(BRASS_HIGHLIGHT);
//		g.drawLine(x+1, y, x+w-2, y);
//		g.drawLine(x, y+1, x, y+h-2);
//		g.setColor(BRASS_SHADOW);
//		g.drawLine(x+1, y+h-1, x+w-2, y+h-1);
//		g.drawLine(x+w-1, y+1, x+w-1, y+h-2);
		Draw.drawImageWithBorder(g, x, y, w, h, Images.BRASS_PANEL,8,true);		
	}
	
	
	public void drawPlate(SynthContext context, Graphics g, int x, int y, int w, int h) {
//		g.setColor(BRASS_COLOR);
//		g.fillRect(x+1, y+1, w-2,h-2);
//		g.setColor(BRASS_HIGHLIGHT);
//		g.drawLine(x+1, y, x+w-2, y);
//		g.drawLine(x, y+1, x, y+h-2);
//		g.setColor(BRASS_SHADOW);
//		g.drawLine(x+1, y+h-1, x+w-2, y+h-1);
//		g.drawLine(x+w-1, y+1, x+w-1, y+h-2);
		Draw.drawImageWithBorder(g, x, y, w, h, Images.PLATE,8,true);		
	}
	
	public void drawAnyMenuItemBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		int state=context.getComponentState();
		if ((state&SynthConstants.MOUSE_OVER)!=0) {
			g.setColor(MENU_COLOR_HIGHLIGHT);
			g.fillRect(x+2, y+2, w-4,h-4);
		} else {
			g.setColor(MENU_ITEM_COLOR);
			g.fillRect(x+2, y+2, w-4,h-4);
		}
	}	
	
	public void drawAnyMenuItemBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		// Do nothing
	}		
	
	public void drawAnyMenuBackground(SynthContext context, Graphics g, int x, int y, int w, int h) {
		int state=context.getComponentState();
		if ((state&SynthConstants.MOUSE_OVER)!=0) {
			g.setColor(MENU_COLOR_HIGHLIGHT);
			g.fillRect(x+2, y+2, w-4,h-4);
		} else {
			g.setColor(MENU_COLOR);
			g.fillRect(x+2, y+2, w-4,h-4);
		}
	}	
	
	public void drawButton(SynthContext context, Graphics g, int x, int y, int w, int h) {
		BufferedImage img=Images.BUTTON_NORMAL;
		if (!context.getComponent().isEnabled()) {
			img=Images.BUTTON_DISABLED;
		} else if ((context.getComponentState()&SynthConstants.PRESSED)!=0) {
			img=Images.BUTTON_PRESSED;
		} else if ((context.getComponentState()&SynthConstants.MOUSE_OVER)!=0) {
			img=Images.BUTTON_HIGHLIGHT;
		}
	
		Draw.drawImageWithBorder(g,x,y,w,h,img,5,true);
	}
	
	public void drawAnyMenuBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		g.setColor(MENU_BORDER);
		g.drawLine(x, y, x+w-1, y);
		g.drawLine(x, y+h-1, x+w-1, y+h-1);
		g.drawLine(x, y, x, y+h-1);
		g.drawLine(x+w-1, y, x+w-1, y+h-1);
	}	

	
	
	// Unrecognised object painting
	
	public void drawUnrecognised(SynthContext context, Graphics g, int x, int y, int w, int h) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, h);
		g.setColor(Color.RED);
		g.drawLine(x, y, x+w, y+h);
		g.drawLine(x, y+h, x+w, y);
		g.drawString(context.getRegion().toString(), x, y+h/2);
	}
	
	public void drawUnrecognisedBorder(SynthContext context, Graphics g, int x, int y, int w, int h) {
		g.setColor(Color.RED);
		g.drawLine(x, y, x+w, y);
		g.drawLine(x, y, x, y+h);
		g.drawString(context.getRegion().toString(), x, y+h);
	}
}
