package model;

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import contract.Idiamond;
import contract.Idirt;
import contract.Irock;
import contract.Isprite;
import contract.Iview;
import main.Main;
import view.Window;

public class Map implements Iview, Isprite, Irock, Idiamond, Idirt {

	private static Timer timer;
	private static int[][] table;
	private static int nbDiamond = 0;
	private static End spriteEnd;
	private static Hero spriteHero;

	public Map() {
		timer = new Timer(16, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				update();
			}
		});
	}

	public static void load(int[][] pTable) {

		table = pTable;

		Window.background.setSize(table[0].length * Main.TILESIZE, table.length * Main.TILESIZE);
		Window.ground.setSize(table[0].length * Main.TILESIZE, table.length * Main.TILESIZE);

		System.out.println("Loading background...");

		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table[y].length; x++) {
				Window.background.add(new Sprite("empty.png", x * Main.TILESIZE, y * Main.TILESIZE));
			}
		}

		System.out.println("Loading map...");

		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table[y].length; x++) {
				switch (table[y][x]) {
				case 1:
					Window.ground.add(new Block(x * Main.TILESIZE, y * Main.TILESIZE), 1);
					break;
				case 2:
					Window.ground.add(new Dirt(x * Main.TILESIZE, y * Main.TILESIZE), 1);
					break;
				case 3:
					Window.ground.add(new Rock(x * Main.TILESIZE, y * Main.TILESIZE), 1);
					break;
				case 4:
					Window.ground.add(new Diamond(x * Main.TILESIZE, y * Main.TILESIZE), 1);
					nbDiamond++;
					break;
				case 5:
					spriteHero = new Hero(x * Main.TILESIZE, y * Main.TILESIZE);
					Window.ground.add(spriteHero, 0);
					break;
				case 6:
					spriteEnd = new End(x * Main.TILESIZE, y * Main.TILESIZE);
					Window.ground.add(spriteEnd, 1);
					break;
				case 7:
					Window.ground.add(new Enemy(x * Main.TILESIZE, y * Main.TILESIZE), 1);
					break;
				default:
					break;
				}
			}
		}
		timer.start();
	}

	public void update() {
		if (Map.nbDiamond - spriteHero.getDiamond() <= 0) {
			spriteEnd.setIsSolid(false);
		}
	}

	public Hero getHero() {
		return spriteHero;
	}

	public void Map() {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	public void Sprite(String pPath, int pX, int pY) {
		// TODO Auto-generated method stub

	}

	public void applyGravity() {
		// TODO Auto-generated method stub

	}

	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void setImage() {
		// TODO Auto-generated method stub

	}

	public void setX(int pX) {
		// TODO Auto-generated method stub

	}

	public void setY(int pY) {
		// TODO Auto-generated method stub

	}

	public void setIsSolid(Boolean pBool) {
		// TODO Auto-generated method stub

	}

	public void setIsActive(Boolean pBool) {
		// TODO Auto-generated method stub

	}

	public void setPath(String pPath) {
		// TODO Auto-generated method stub

	}

	public void setSpeed(int pSpeed) {
		// TODO Auto-generated method stub

	}

	public void setAlive(Boolean pBool) {
		// TODO Auto-generated method stub

	}

	public Boolean getAlive() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getIsSolid() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Boolean getIsActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMap(String pMap) {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}
}
