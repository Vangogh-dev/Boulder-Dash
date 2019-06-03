package model;

import contract.Idirt;

public class Dirt extends Sprite implements Idirt {

	public Dirt(int pX, int pY) {
		super(pX, pY);
		this.path = "dirt.png";
		this.setImage();
	}

	public String toString() {
		return "type:Dirt " + super.toString();
	}
}
