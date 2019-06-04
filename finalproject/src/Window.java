import java.sql.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JFrame {

	private Hero hero;
	private JPanel panel = new JPanel();
	private Map map = new Map();

	public static JLayeredPane background = new JLayeredPane();
	public static JLayeredPane ground  = new JLayeredPane();

	public static int[][] data = new int[Main.COUNT][Main.COUNT];

	public static void setMap(String pMap) throws SQLException, ClassNotFoundException {
		data = Connector.getMap(pMap);
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
		map.load(data);
		addKeyListener(map.getHero());
	}

}
