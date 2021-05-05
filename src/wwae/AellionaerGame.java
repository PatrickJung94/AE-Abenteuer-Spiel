package wwae;

import javax.swing.*;

public class AellionaerGame {
	private CreateQuestion createQuestion;
	public static void main(String[] args) {
		new AellionaerGame();
	}

	public AellionaerGame() {
		init();
	}
	
	private void init() {
		JFrame window = new JFrame("Wer wird AEllion�r");
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		createQuestion = new CreateQuestion();
		createQuestion.showForm();
		
		
		window.setSize(1280, 720);
		window.setVisible(true);
		window.setResizable(false);
	}
}
