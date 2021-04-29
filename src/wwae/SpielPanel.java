package wwae;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;


public class SpielPanel {
	
	JFrame window = new JFrame("Wer wird AEllionär");

	JPanel answers = new JPanel();
	JPanel infoPanel = new JPanel();
	JLabel questionLabel = new JLabel();
	JPanel listenPanel = new JPanel();
	JPanel jokerPanel = new JPanel();
	JPanel leiterPanel = new JPanel();

	String[] answerPossibilities = new String[4];
	String question = new String();
	
	Font  f = new Font(Font.SERIF,Font.BOLD, 50);
	BoxLayout boxLayout = new BoxLayout(listenPanel, BoxLayout.Y_AXIS);
	GridLayout boxLayoutJoker = new GridLayout(4,1);
	JButton joker50 = new JButton("50/50");
	JButton jokerTelefon = new JButton("Telefonjoker");
	JButton jokerPublikum = new JButton("Publikumsjoker");
	JButton jokerZusatz = new JButton("Zusatzjoker");
	
	
	
	
	public SpielPanel() {
		init();
	}
	
	
	private void init() {
		
		
		setAnswerPossibilities();
		setQuestion();
		
		
		answers.setLayout(new GridLayout(2,2));
		answers.setPreferredSize(new Dimension(1280,220));
		for(int i= 0; i<4; i++) {
			answers.add(new JButton(answerPossibilities[i]));
		}
		
		
		questionLabel.setFont(f);
		infoPanel.setLayout(new BorderLayout());
		
		infoPanel.add(jokerPanel, BorderLayout.WEST);
		infoPanel.add(leiterPanel, BorderLayout.EAST);
		infoPanel.add(questionLabel, BorderLayout.SOUTH);
		
		jokerPanel.setLayout(boxLayoutJoker);
		jokerPanel.add(joker50);
		jokerPanel.add(jokerTelefon);
		jokerPanel.add(jokerPublikum);
		jokerPanel.add(jokerZusatz);
		listenPanel.setLayout(boxLayout);
		listenPanel.add(Box.createRigidArea(new Dimension(3,1)));
		listenPanel.add(infoPanel);
		listenPanel.add(answers);
			
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		window.getContentPane().add(listenPanel);
		window.setSize(1280, 720);
		window.setVisible(true);
		window.setResizable(false);
		joker50.setPreferredSize(new Dimension(1000,1000));
	}
	
	
	public void setAnswerPossibilities(){
		// später an DB anbinden, aktuell noch Mockdaten
		
		answerPossibilities[0] = "A: Anwendungsschicht";
		answerPossibilities[1] = "B: Sicherungsschicht";
		answerPossibilities[2] = "C: Bitübertragungsshicht";
		answerPossibilities[3] = "D: Transportschicht";
	}
	
	public void setQuestion() {
		// später an DB anbinden, aktuell noch Mockdaten
		
		this.question = "         Wie lautet die zweite Schicht des OSI-Models ? ";
		this.questionLabel.setText(question);
	}
	
	
	public static void main(String[] args) {
		SpielPanel spielpanel = new SpielPanel();
	}
	
	
	
}
