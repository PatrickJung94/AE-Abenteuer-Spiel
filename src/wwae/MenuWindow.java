package wwae;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class MenuWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private AellionaerGame gameContext;
	private CreateQuestion createQuestion;
	private HighScorePopup highScorePopup;
	private int numberHiscorePopup = 0;
	private FileSystem fs = new FileSystem();

	public MenuWindow(AellionaerGame _gameContext) {
		super("Men� - Wer wird AEllion�r");
		gameContext = _gameContext;
		createLayout();
	}
	
	private void createLayout() {
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		AbstractBorder border = new TextBubbleBorder(new Color(0, 0, 0),1,30,0);
		
		Container pane = this.getContentPane();
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(3, 1));
		JPanel menuBlockTop = new JPanel();
		menuBlockTop.setLayout(new GridBagLayout());
		JPanel menuBlockButtons = new JPanel();
		menuBlockButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		JPanel menuBlockBottom = new JPanel();
		
		JButton startBtn = new JButton("Start");
		startBtn.setBorder(border);
		JButton settingsBtn = new JButton("Einstellungen");
		settingsBtn.setBorder(border);
		JButton exitBtn = new JButton("Beenden");
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
		
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(400, 400));
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(400, 400));
		
		JPanel optionBar = new JPanel();
		Color optionPanelColor = new Color(220,220,220);
		optionBar.setBorder(BorderFactory.createMatteBorder(18, 0, 0, 0, optionPanelColor));
		optionBar.setPreferredSize(new Dimension(getSize().width, 75));
		optionBar.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 0));
		JButton highscore = new JButton("Highscore anzeigen");
		highscore.setPreferredSize(new Dimension(highscore.getPreferredSize().width + 30, 40));
		highscore.setBorder(border);
		JButton addQuestions = new JButton("Fragen anlegen");
		addQuestions.setPreferredSize(new Dimension(addQuestions.getPreferredSize().width + 30, 40));
		addQuestions.setBorder(border);
		JButton chooseSubject = new JButton("Fach ausw�hlen");
		chooseSubject.setPreferredSize(new Dimension(chooseSubject.getPreferredSize().width + 30, 40));
		chooseSubject.setBorder(border);
		JButton difficulty = new JButton("Schwierigkeitsgrad");
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
		int y= 450;
		int locationX=this.getX() + (this.getWidth() / 2) - (x / 2);
		int locationY=this.getY() + (this.getHeight() / 2) - (y / 2);
		
		highScorePopup = new HighScorePopup(fs.getRankingsSortedByScore(), x, y, locationX, locationY);
		highScorePopup.setVisible(true);
	}
	public void showMenu() {
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setResizable(false);
		//createpopup();
		
	}
	
	public void hideMenu() {
		this.setVisible(false);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
