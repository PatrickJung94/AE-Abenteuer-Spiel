package wwae;

import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class MenuWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private AellionaerGame gameContext;
	private CreateQuestion createQuestion;

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
		
		JLabel header = new JLabel("Wer wird AEllion�r");
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
		
		
		pane.add(BorderLayout.WEST, left);
		pane.add(BorderLayout.CENTER, menuPanel);
		pane.add(BorderLayout.EAST, right);
		pane.add(BorderLayout.PAGE_END, optionBar);
	}
	
	public void showMenu() {
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void hideMenu() {
		this.setVisible(false);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
