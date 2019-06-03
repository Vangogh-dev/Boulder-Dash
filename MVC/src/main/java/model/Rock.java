package model;

import javax.swing.JPanel;

import contract.Irock;

public class Rock extends Sprite implements Irock {

	public Rock(int pPosX, int pPosY) {
		super(pPosX, pPosY);
		this.path = "rock.png";
		this.isSolid = true;
		this.isMoveable = true;
		this.setImage();
	}

	public String toString() {
		return "type:Rock " + super.toString();
	}

	public void update() {
		super.update();
		applyGravity();
	}
}
