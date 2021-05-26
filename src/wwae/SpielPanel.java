package wwae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.border.AbstractBorder;


import javax.swing.*;

public class SpielPanel extends JFrame {

	private AellionaerGame gameContext;
	private static final long serialVersionUID = 1L;
	JPanel answers = new JPanel();
	JPanel infoPanel = new JPanel();
	JLabel questionLabel = new JLabel();
	JPanel listenPanel = new JPanel();
	JPanel jokerPanel = new JPanel();
	JPanel leiterPanel = new JPanel();
	
	String[] answerPossibilities = new String[4];
	String question = new String();

	Font f = new Font(Font.SERIF, Font.BOLD, 50);
	BoxLayout boxLayout = new BoxLayout(listenPanel, BoxLayout.Y_AXIS);
	GridLayout boxLayoutJoker = new GridLayout(4, 1);
	GridLayout boxLayoutLeiter = new GridLayout(10, 1);
	
	JButton joker50 = new JButton("50/50");
	JButton jokerTelefon = new JButton("Telefonjoker");
	JButton jokerPublikum = new JButton("Publikumsjoker");
	JButton jokerZusatz = new JButton("Zusatzjoker");
	
	public SpielPanel(AellionaerGame _gameContext) {
		super("Men�- Wer wird AEllion�r");
		gameContext = _gameContext;
		init();
	}

	private void init() {

		setAnswerPossibilities();
		setQuestion();
		AbstractBorder border = new TextBubbleBorder(new Color(0, 0, 0),1,30,0);

		joker50.setBorder(border);
		jokerTelefon.setBorder(border);
		jokerPublikum.setBorder(border);
		jokerZusatz.setBorder(border);
		


		answers.setLayout(new GridLayout(2, 2));
		answers.setPreferredSize(new Dimension(1280, 220));
		JButton[] buttons = new JButton[4];
		
		for (int i = 0; i < 4; i++) {
			buttons[i] = new JButton(answerPossibilities[i]);
			answers.add(buttons[i]);
		}

		buttons[0].setBorder(border);
		buttons[1].setBorder(border);
		buttons[2].setBorder(border);
		buttons[3].setBorder(border);
		
		
		questionLabel.setFont(f);
		infoPanel.setLayout(new BorderLayout());

		infoPanel.add(jokerPanel, BorderLayout.WEST);
		infoPanel.add(leiterPanel, BorderLayout.EAST);
		infoPanel.add(questionLabel, BorderLayout.SOUTH);

		leiterPanel.setLayout(boxLayoutLeiter);
		
		int i=10;
		JButton[] labels = new JButton[11];  
		while (i>0) {
			labels[i] = new JButton(String.valueOf(i*10));
			leiterPanel.add(labels[i]);
			labels[i].setBorder(border);
			System.out.println(i);
			i=i-1;
		}


		

		jokerPanel.setLayout(boxLayoutJoker);
		jokerPanel.add(joker50);
		jokerPanel.add(jokerTelefon);
		jokerPanel.add(jokerPublikum);
		jokerPanel.add(jokerZusatz);
		
		
		listenPanel.setLayout(boxLayout);
		listenPanel.add(Box.createRigidArea(new Dimension(3, 1)));
		listenPanel.add(infoPanel);
		listenPanel.add(answers);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(listenPanel);
		this.setPreferredSize(new Dimension(1000, 1000));
	}

	public void setAnswerPossibilities() {
		// sp�ter an DB anbinden, aktuell noch Mockdaten

		answerPossibilities[0] = "A: Anwendungsschicht";
		answerPossibilities[1] = "B: Sicherungsschicht";
		answerPossibilities[2] = "C: Bit�bertragungsshicht";
		answerPossibilities[3] = "D: Transportschicht";
	}

	public void setQuestion() {
		// sp�ter an DB anbinden, aktuell noch Mockdaten

		this.question = "                               Wie lautet die zweite Schicht des OSI-Models ? ";
		this.questionLabel.setText(question);
	}
	
	public void showGamePanel() {
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void hideGamePanel() {
        this.setVisible(false);
    }

    public void close() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

	

}
