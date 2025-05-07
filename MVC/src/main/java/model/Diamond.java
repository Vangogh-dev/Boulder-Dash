package model;

import javax.swing.JPanel;
import contract.Idiamond;

public class Diamond extends Sprite implements Idiamond {

	public Diamond(int pX, int pY) {
		super(pX, pY);
		this.path = "diamond.png";
		this.setImage();
	}

	public String toString() {
		return "type:Diamond " + super.toString();
	}

	public void update() {
		super.update();
		applyGravity();
	}
}
