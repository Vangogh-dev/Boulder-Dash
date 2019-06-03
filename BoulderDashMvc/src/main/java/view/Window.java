package view;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import contract.Iview;
import main.Main;
import model.Connector;
import model.Hero;
import model.Map;

public class Window extends JFrame implements Iview {

	private Hero hero;
	private JPanel panel = new JPanel();
	private Map map = new Map();

	public static JLayeredPane background = new JLayeredPane();
	public static JLayeredPane ground = new JLayeredPane();

	public int[][] data = new int[Main.COUNT][Main.COUNT];

	public void setMap(String pMap) {
		try {
			data = Connector.getMap(pMap);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Window(String pTitle, int pWidth, int pHeight) {
		this.setTitle(pTitle);
		this.setVisible(true);
		this.setSize(pWidth, pHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(panel);

		panel.setLayout(new BorderLayout());
		panel.add(ground, 0);
		panel.add(background, 1);
	}

	public void init() {
		model.Map.load(data);
		addKeyListener(map.getHero());
	}

}
