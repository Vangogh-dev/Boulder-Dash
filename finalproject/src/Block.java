

public class Block extends Sprite {

	public Block(int pX, int pY) {
		super(pX, pY);
		this.path = "block.png";
		this.isSolid = true;
		this.setImage();
	}

	public String toString() {
		return "type:Block " + super.toString();
	}
}
