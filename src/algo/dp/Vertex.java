package algo.dp;

public class Vertex {
	int color,val;

	public Vertex(int color, int val) {
		super();
		this.color = color;
		this.val = val;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "Vertex1 [color=" + color + ", val=" + val + "]";
	}
}
