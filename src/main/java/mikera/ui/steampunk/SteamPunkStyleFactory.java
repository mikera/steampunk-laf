package mikera.ui.steampunk;

import javax.swing.JComponent;
import javax.swing.plaf.synth.Region;
import javax.swing.plaf.synth.SynthStyle;
import javax.swing.plaf.synth.SynthStyleFactory;

public class SteamPunkStyleFactory extends SynthStyleFactory {
	private SynthStyle defaultStyle=new SteamPunkStyle();
	
	@Override
	public SynthStyle getStyle(JComponent c, Region id) {
	
		return defaultStyle;
	}


}
