package wwae;

import javax.swing.JOptionPane;

public class AellionaerGame {
	private MenuWindow menu = new MenuWindow(this);
	private RankEntry re = new RankEntry(this);
	private Difficulty d = Difficulty.LOW;
	private SpielPanel gp = new SpielPanel(this);
	private String bundle = "output";
	private FileSystem fs = new FileSystem(); 
	
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
		
		if(fs.isBundleFull(bundle)){
			menu.hideMenu();
			gp.showGamePanel(this.bundle);
		}else{
			JOptionPane.showOptionDialog(null, "Es fehlen noch Fragen im Bundle !", "Bundle Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
		}


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
	}
	
	public void addRankToMenu() {
		re.hideEntry();
		menu.showMenu();
	}
}
