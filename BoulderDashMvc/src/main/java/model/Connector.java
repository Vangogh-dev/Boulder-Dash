package model;

import java.sql.*;

public class Connector {

	static String url = "db4free.net";
	static String user = "antoine";
	static String passwd = "porteclefs";
	static String base = "boulderdash";

	public static int getCount(String pMap) throws SQLException, ClassNotFoundException {

		// openConnection()
		Class.forName("org.mariadb.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + base, user, passwd);

		// callProcedure()
		String query = "{CALL getMapCount(?)}";
		CallableStatement st = cn.prepareCall(query);
		st.setString(1, pMap);
		ResultSet rs = st.executeQuery();

		// cacheData()
		ResultSetMetaData rsMeta = rs.getMetaData();
		int count = rsMeta.getColumnCount();

		cn.close();
		st.close();

		return count;
	}

	public static int[][] getMap(String pMap) throws SQLException, ClassNotFoundException {

		// openConnection()
		Class.forName("org.mariadb.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + base, user, passwd);

		// callProcedure()
		String query = "{CALL displayMap(?)}";
		CallableStatement st = cn.prepareCall(query);
		st.setString(1, pMap);
		ResultSet rs = st.executeQuery();

		// parseResultsInArray()
		ResultSetMetaData rsMeta = rs.getMetaData();
		int count = rsMeta.getColumnCount();
		int[][] map = new int[count][count];
		int x = 0;

		while (rs.next()) {
			for (int i = 0; i < count; i++) {
				map[x][i] = rs.getInt(i + 1);
			}

			x++;
		}

		// showMapArray()
		for (int[] z : map) {
			for (int j : z) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		// closeConnection()
		cn.close();
		st.close();

		return map;
	}

	public static void addScore(int p_score) throws SQLException, ClassNotFoundException {

		// openConnection()
		Class.forName("org.mariadb.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + base, user, passwd);

		// callProcedure()
		String query = "{CALL addScore(?)}";
		CallableStatement st = cn.prepareCall(query);
		st.setInt(1, p_score);
		ResultSet rs = st.executeQuery();

		// return()
		System.out.println("New score added : " + p_score);

		// closeConnection()
		cn.close();
		st.close();
	}

	public static void getScores() throws SQLException, ClassNotFoundException {

		// openConnection()
		Class.forName("org.mariadb.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + base, user, passwd);

		// callProcedures()
		String queryLS = "{CALL getLastScore()}";
		String queryBS = "{CALL getBestScore()}";

		CallableStatement stLS = cn.prepareCall(queryLS);
		ResultSet rsLS = stLS.executeQuery();

		CallableStatement stBS = cn.prepareCall(queryBS);
		ResultSet rsBS = stBS.executeQuery();

		// showLastScore()
		while (rsLS.next()) {
			System.out.println("Last score : " + rsLS.getInt("value"));
		}

		// showBestScore()
		while (rsBS.next()) {
			System.out.println("Best score : " + rsBS.getInt("MAX(`value`)"));
		}

		// closeConnection()
		cn.close();
		stLS.close();
		stBS.close();
	}
}
