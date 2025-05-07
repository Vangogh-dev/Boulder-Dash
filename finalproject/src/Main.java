import java.sql.*;

public class Main {

	public static int COUNT = 0;
	public static String MAP = "world_1_1";

	static int SCALE = 2;
	static int TILESIZE = 16 * SCALE;
	static int WIDTH  = 16 * TILESIZE;
	static int HEIGHT = 16 * TILESIZE;
	static int OFFSETX = 0;
	static int OFFSETY = 0;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		if (args.length >= 1) {
			MAP = args[0];
		}

		COUNT = Connector.getCount(MAP);
		Window.setMap(MAP);

		Window w = new Window("Boulder dash", WIDTH, HEIGHT);
		w.init();

		while(true) {
			w.repaint();
		}
	}
}
