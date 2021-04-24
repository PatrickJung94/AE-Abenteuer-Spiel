package wwae;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;


public class SpielPanel {
	
	JFrame window = new JFrame("Wer wird AEllionär");

	JPanel answers = new JPanel();
	JPanel questionPanel = new JPanel();
	JLabel questionLabel = new JLabel();
	JPanel listenPanel = new JPanel();

	String[] answerPossibilities = new String[4];
	String question = new String();
	
	Font  f = new Font(Font.SERIF,Font.BOLD, 50);
	
	BoxLayout boxLayout = new BoxLayout(listenPanel, BoxLayout.Y_AXIS);
	
	
	
	
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
		questionPanel.setLayout(new BorderLayout());
		
		questionPanel.add(questionLabel, BorderLayout.SOUTH);
		
		listenPanel.setLayout(boxLayout);
		listenPanel.add(Box.createRigidArea(new Dimension(3,1)));
		listenPanel.add(questionPanel);
		listenPanel.add(answers);
			
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		window.getContentPane().add(listenPanel);
		window.setSize(1280, 720);
		window.setVisible(true);
		window.setResizable(false);
	}
	
	
	public void setAnswerPossibilities(){
		// später an DB anbinden, aktuell noch Mockdaten
		
		answerPossibilities[0] = "A: Das könnte richtig sein";
		answerPossibilities[1] = "B: Das könnte richtig sein";
		answerPossibilities[2] = "C: Das könnte richtig sein";
		answerPossibilities[3] = "D: Das könnte richtig sein";
	}
	
	public void setQuestion() {
		// später an DB anbinden, aktuell noch Mockdaten
		
		this.question = "Das ist eine tolle Frage";
		this.questionLabel.setText(question);
	}
	
	
	public static void main(String[] args) {
		SpielPanel spielpanel = new SpielPanel();
	
	}
	
	
	
}
