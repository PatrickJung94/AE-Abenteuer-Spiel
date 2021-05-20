package wwae;

import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class MenuWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private AellionaerGame gameContext;
	private CreateQuestion createQuestion;
	private HighScorePopup highScorePopup;
	private int numberHiscorePopup = 0;
	
	private JPanel menuPanel = new JPanel();
	private JPanel menuBlockTop = new JPanel();
	private JPanel menuBlockButtons = new JPanel();
	private JPanel menuBlockBottom = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();
	private JPanel optionBar = new JPanel();
	private JButton startBtn = new JButton("Start");
	private JButton settingsBtn = new JButton("Einstellungen");
	private JButton exitBtn = new JButton("Beenden");
	private JButton highscore = new JButton("Highscore anzeigen");
	private JButton addQuestions = new JButton("Fragen anlegen");
	private JButton chooseSubject = new JButton("Fach auswählen");
	private JButton difficulty = new JButton("Schwierigkeitsgrad");
	
	public MenuWindow(AellionaerGame _gameContext) {
		super("Menü - Wer wird AEllionär");
		gameContext = _gameContext;
		createLayout();
	}
	
	private void createLayout() {
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		AbstractBorder border = new TextBubbleBorder(new Color(0, 0, 0),1,30,0);
		
		Container pane = this.getContentPane();
		
		
		menuPanel.setLayout(new GridLayout(3, 1));
		
		menuBlockTop.setLayout(new GridBagLayout());
		
		menuBlockButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		
		
		
		startBtn.setBorder(border);
		
		settingsBtn.setBorder(border);
		
		exitBtn.setBorder(border);
		
		startBtn.setPreferredSize(new Dimension(460, 35));
		settingsBtn.setPreferredSize(new Dimension(460, 35));
		exitBtn.setPreferredSize(new Dimension(460, 35));
		
		menuPanel.add(menuBlockTop);
		menuPanel.add(menuBlockButtons);
		menuPanel.add(menuBlockBottom);
		String ouml = "Wer wird AEllion\u00e4r";
		JLabel header = new JLabel(ouml);
		header.setFont(new Font(header.getFont().getName(), Font.PLAIN, 36));
		menuBlockTop.add(header);
		menuBlockButtons.add(startBtn);
		menuBlockButtons.add(settingsBtn);
		menuBlockButtons.add(exitBtn);
		
		startBtn.addActionListener(event -> {
			gameContext.menuToGamePanel();
		});
		
		left.setPreferredSize(new Dimension(400, 400));
		right.setPreferredSize(new Dimension(400, 400));
		
		Color optionPanelColor = new Color(220,220,220);
		
		optionBar.setBorder(BorderFactory.createMatteBorder(18, 0, 0, 0, optionPanelColor));
		optionBar.setPreferredSize(new Dimension(getSize().width, 75));
		optionBar.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 0));
		
		highscore.setPreferredSize(new Dimension(highscore.getPreferredSize().width + 30, 40));
		highscore.setBorder(border);
		
		addQuestions.setPreferredSize(new Dimension(addQuestions.getPreferredSize().width + 30, 40));
		addQuestions.setBorder(border);
		
		chooseSubject.setPreferredSize(new Dimension(chooseSubject.getPreferredSize().width + 30, 40));
		chooseSubject.setBorder(border);
		
		difficulty.setPreferredSize(new Dimension(difficulty.getPreferredSize().width + 30, 40));
		difficulty.setBorder(border);
		optionBar.setBackground(optionPanelColor);
		
		optionBar.add(highscore);
		optionBar.add(addQuestions);
		optionBar.add(chooseSubject);
		optionBar.add(difficulty);

		addQuestions.addActionListener(event -> {
			createQuestion = new CreateQuestion();
			createQuestion.showForm();
		});
		
		highscore.addActionListener(event -> {
			if (numberHiscorePopup == 0) {
				createpopup();
			}
			if (highScorePopup.isVisible()) {
				numberHiscorePopup = 1;
				highScorePopup.setVisible(true);
			}else {
				numberHiscorePopup = 0;
				highScorePopup.dispatchEvent(new WindowEvent(highScorePopup, WindowEvent.WINDOW_CLOSING));
				highscore.doClick();
			}
		});
		
		
		pane.add(BorderLayout.WEST, left);
		pane.add(BorderLayout.CENTER, menuPanel);
		pane.add(BorderLayout.EAST, right);
		pane.add(BorderLayout.PAGE_END, optionBar);
	}
	public void createpopup() {
		numberHiscorePopup = 0;
		int x= 500;
		int y= 420;
		int locationX=this.getX() + (this.getWidth() / 2) - (x / 2);
		int locationY=this.getY() + (this.getHeight() / 2) - (y / 2);
		 String data[] = { "omss  ssss sar1aas", "10098222830", "2021-10-10 13:30", "omar2", "200", "2021-10-10 13:30",
				"omar3", "300", "2021-10-10 13:30", "omar4", "400", "2021-10-10 13:30", "omar5", "500",
				"2021-10-10 12:30", "omar6", "600", "2021-10-10 12:30", "omar7", "700", "2021-10-10 12:30", "omar8",
				"800", "2021-10-10 12:30", "omar9", "900", "2021-10-10 12:30", "omar10", "1000", "2021-10-12 10:30",
				"omar1", "1000", "2021-10-12 10:30", "omar2", "200", "2021-10-12 10:30", "omar3", "300",
				"2021-10-12 10:30", "omar4", "400", "2021-10-12 10:30", "omar5", "500", "2021-10-12 10:30", "omar6",
				"600", "2021-10-12 10:30", "omar7", "700", "2021-10-12 10:30", "omar8", "800", "2021-10-12 10:30",
				"om ar22", "900", "2021-10-12 10:30", "omar10", "1000", "2021-10-12 10:30"};
		highScorePopup = new HighScorePopup(data,x,y,locationX,locationY);
		highScorePopup.setVisible(true);
	}
	public void showMenu() {
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setResizable(false);
		//createpopup();
		System.out.println(this.chooseSubject.getWidth());	
		
	}
	
	public void hideMenu() {
		this.setVisible(false);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
