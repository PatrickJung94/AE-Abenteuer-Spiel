package wwae;

import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MenuWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public MenuWindow() {
		super("Menü - Wer wird AEllionär");
		createLayout();
	}
	
	private void createLayout() {
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		Container pane = this.getContentPane();
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(3, 1));
		JPanel menuBlockTop = new JPanel();
		menuBlockTop.setLayout(new GridBagLayout());
		JPanel menuBlockButtons = new JPanel();
		menuBlockButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		JPanel menuBlockBottom = new JPanel();
		
		JButton startBtn = new JButton("Start");
		JButton settingsBtn = new JButton("Einstellungen");
		JButton exitBtn = new JButton("Beenden");
		
		startBtn.setPreferredSize(new Dimension(460, 35));
		settingsBtn.setPreferredSize(new Dimension(460, 35));
		exitBtn.setPreferredSize(new Dimension(460, 35));
		
		menuPanel.add(menuBlockTop);
		menuPanel.add(menuBlockButtons);
		menuPanel.add(menuBlockBottom);
		
		JLabel header = new JLabel("Wer wird AEllionär");
		header.setFont(new Font(header.getFont().getName(), Font.PLAIN, 36));
		menuBlockTop.add(header);
		
		menuBlockButtons.add(startBtn);
		menuBlockButtons.add(settingsBtn);
		menuBlockButtons.add(exitBtn);
		
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(400, 400));
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(400, 400));
		
		JPanel optionBar = new JPanel();
		optionBar.setPreferredSize(new Dimension(getSize().width, 75));
		optionBar.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 25));
		JButton highscore = new JButton("Highscore anzeigen");
		JButton addQuestions = new JButton("Fragen anlegen");
		JButton chooseSubject = new JButton("Fach auswählen");
		JButton difficulty = new JButton("Schwierigkeitsgrad");
		optionBar.setBackground(new Color(220,220,220));
		
		optionBar.add(highscore);
		optionBar.add(addQuestions);
		optionBar.add(chooseSubject);
		optionBar.add(difficulty);
		
		
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
