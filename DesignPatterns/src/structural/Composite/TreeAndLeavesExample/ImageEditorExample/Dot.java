package structural.Composite.TreeAndLeavesExample.ImageEditorExample;

public class Dot implements Graphic {
	private int x, y;
	
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void drag(int x, int y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public void draw() {
		System.out.println("drawing a dot at x{ " + x + " } y{ " + y + " }");
	}

}
