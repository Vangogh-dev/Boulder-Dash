package contract;

import model.Hero;

public interface Imap {

	void load(int[][] pTable);

	void update();

	Hero getHero();
}
