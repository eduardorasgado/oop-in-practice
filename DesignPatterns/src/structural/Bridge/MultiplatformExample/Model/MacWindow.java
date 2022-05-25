package structural.Bridge.MultiplatformExample.Model;

import java.util.List;

public class MacWindow extends UIElement implements IWindow {
	public List<IFrame> frame;
	
	@Override
	public void render() {
		System.out.println("Drawing a mac window");
	}
}
