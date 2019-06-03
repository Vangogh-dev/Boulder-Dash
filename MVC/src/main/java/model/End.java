package model;

import java.awt.Component;

import contract.Iend;

public class End extends Sprite implements Iend {

	public End(int pX, int pY) {
		super(pX, pY);
		this.path = "block.png";
		this.isSolid = true;
		this.setImage();
	}

	public String toString() {
		return "type:End" + super.toString();
	}

	public void update() {
		super.update();
	}

	public void setIsSolid(Boolean pBool) {

		super.setIsSolid(pBool);
		if (pBool) {
			this.path = "block.png";
		} else {
			this.path = "end.png";
		}
		this.setImage();
	}
}
