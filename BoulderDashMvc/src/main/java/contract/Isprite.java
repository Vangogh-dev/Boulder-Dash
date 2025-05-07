package contract;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

public interface Isprite {

	void actionPerformed(ActionEvent evt);

	void Sprite(String pPath, int pX, int pY);

	void applyGravity();

	void update();

	void paintComponent(Graphics g);

	void setImage();

	void setX(int pX);

	void setY(int pY);

	void setIsSolid(Boolean pBool);

	void setIsActive(Boolean pBool);

	void setPath(String pPath);

	void setSpeed(int pSpeed);

	void setAlive(Boolean pBool);

	Boolean getAlive();

	Boolean getIsSolid();

	int getSpeed();

	Boolean getIsActive();

}
