package controller;

import contract.Imap;
import contract.Iview;

/**
 * The Class Controller.
 */
public final class Controller implements Iview{
	
	private Iview pview;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final Iview pview, final Iview map) {
		this.setView(pview);
		this.setMap(map);
	}

	private void setMap(final Imap map) {

	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final Iview pview) {
		this.pview = pview;
	}

	public void setMap(String pMap) {
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

}
