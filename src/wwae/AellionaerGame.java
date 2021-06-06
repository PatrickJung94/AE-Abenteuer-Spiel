package wwae;

public class AellionaerGame {
	private String bundle = "ae";
	private MenuWindow menu = new MenuWindow(this);
	private RankEntry re = new RankEntry(this);
	private Difficulty d = Difficulty.LOW;
	private SpielPanel gp = new SpielPanel(this);
	
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

	public Difficulty getDifficulty() {
		return d;
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

	public void showSaveScore(int score) {
		gp.hideGamePanel();
		re.showEntry(score);
		gp = new SpielPanel(this);
	}
	
	public void addRankToMenu() {
		re.hideEntry();
		menu.showMenu();
	}

	public void setActiveBundle(String bundleName) {
		this.bundle = bundleName;
	}
	
	public String getActiveBundle() {
		return bundle;
	}
}
