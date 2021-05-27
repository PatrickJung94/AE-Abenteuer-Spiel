package wwae;

import java.util.Date;

public class AellionaerGame {
	private MenuWindow menu = new MenuWindow(this);
	private SpielPanel gp = new SpielPanel(this);
	
	public static void main(String[] args) {
		new AellionaerGame();

		FileSystem fs = new FileSystem();
		fs.addRankingEntry(new Rank("Max", 2000));
		for (Rank r : fs.getRankings()) {
			System.out.println(r.getName() + " " + r.getScore() + " " + r.getTimestamp());
		}
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
		gp.showGamePanel();
	}
	
}
