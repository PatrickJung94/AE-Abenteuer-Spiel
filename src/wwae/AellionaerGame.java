package wwae;

import javax.swing.*;

public class AellionaerGame {
	public static void main(String[] args) {
		new AellionaerGame();
	}

	public AellionaerGame() {
		init();
	}
	
	private void init() {
		JFrame window = new JFrame("Wer wird AEllionär");
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		window.setSize(1280, 720);
		window.setVisible(true);
		window.setResizable(false);
	}
}
