package mikera.ui.steampunk;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("serial")
public class SteamPunkCellRenderer extends JLabel implements ListCellRenderer<String> {
	protected boolean isSelected=false;
	protected boolean hasFocus=false;
	
	public SteamPunkCellRenderer(String string) {
		super(string);
	}

	public SteamPunkCellRenderer() {
		this("");
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value,
			int index, boolean isSelected, boolean cellHasFocus) {
		SteamPunkCellRenderer rend= new SteamPunkCellRenderer(value.toString());
		if (isSelected) {
			rend.isSelected=isSelected;
			rend.setForeground(Color.WHITE);
			rend.setBackground(Color.BLUE);
		}
		if (cellHasFocus) {
			rend.hasFocus=cellHasFocus;
		}
		return rend;
	}

	@Override
	public boolean isOpaque() {
		return false;
	}
}
