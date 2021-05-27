package wwae;

public class AellionaerGame {
	private MenuWindow menu = new MenuWindow(this);
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
		gp.showGamePanel();
	}
	
}
