package wwae;

public class AellionaerGame {
	private MenuWindow menu = new MenuWindow(this);
	private SpielPanel gp = new SpielPanel(this);
	private Difficulty d = Difficulty.LOW;
	private String bundle = "output";
	
	public static void main(String[] args) {
		new AellionaerGame();
	}

	public AellionaerGame() {
		menu.showMenu();
	}
	
	public void gamePanelToMenu() {
		gp.hideGamePanel();
		menu.showMenu();
	}
	
	public void menuToGamePanel() {
		menu.hideMenu();
		gp.showGamePanel(this.bundle);
	}

	public void changeDifficulty(Difficulty _d) {
		d = _d;
		switch (d) {
			case LOW:
				menu.updateDiffLabel("Schwierigkeitsgrad: Leicht");
				break;
			case MEDIUM:
				menu.updateDiffLabel("Schwierigkeitsgrad: Mittel");
				break;
			case HARD:
				menu.updateDiffLabel("Schwierigkeitsgrad: Schwer");
				break;
		}
	}
	
}
