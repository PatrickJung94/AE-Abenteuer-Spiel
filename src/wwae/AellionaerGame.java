package wwae;

public class AellionaerGame {
	public static void main(String[] args) {
		new AellionaerGame();
	}
	
	private MenuWindow menu;

	public AellionaerGame() {
		menu = new MenuWindow();
		
		menu.showMenu();
	}
}
