package wwae;

import javax.swing.*;

public class AellionaerGame {
	
	private SpielPanel spielPanel;
	
	
	public static void main(String[] args) {
		new AellionaerGame();
	}

	public AellionaerGame() {
		spielPanel = new SpielPanel();
		spielPanel.showGamePanel();
		
	}
	
}
