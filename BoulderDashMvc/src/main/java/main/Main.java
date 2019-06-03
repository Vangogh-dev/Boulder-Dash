package main;

import java.sql.SQLException;

import contract.Iview;
import model.Connector;
import view.Window;

public abstract class Main extends Window implements Iview {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main(String pTitle, int pWidth, int pHeight) {
		super(pTitle, pWidth, pHeight);
		// TODO Auto-generated constructor stub
	}

	public static int COUNT = 0;
	public String MAP = "world_1_1";

	static int SCALE = 2;
	public static int TILESIZE = 16 * SCALE;
	public int WIDTH = 16 * TILESIZE;
	public int HEIGHT = 16 * TILESIZE;
	public static int OFFSETX = 0;
	public static int OFFSETY = 0;

	public void main(String[] args) throws SQLException, ClassNotFoundException {

		if (args.length >= 1) {
			MAP = args[0];
		}

		COUNT = Connector.getCount(MAP);

		Window w = new Window("Boulder dash", WIDTH, HEIGHT);
		w.setMap(MAP);

		w.init();

		while (true) {
			w.repaint();
		}
	}
}
