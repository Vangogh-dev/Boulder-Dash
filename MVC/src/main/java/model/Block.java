package model;

import contract.Iblock;

public class Block extends Sprite implements Iblock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

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
