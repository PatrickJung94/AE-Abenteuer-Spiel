package wwae;

import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.*;

import wwae.Question;

public class CreateQuestion extends JFrame{
	// add import of file
	Question newQuestion = new Question();
	
	public CreateQuestion() {
		super("Frage erstellen/bearbeiten - Wer wird AEllion�r");
		createForm();
	}
	
	private void createForm() {
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		Container pane = this.getContentPane();

		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(5, 2));
		
		JPanel menuBlockTop = new JPanel();
//		menuBlockTop.setLayout(new GridBagLayout());
		menuBlockTop.setBackground(new Color(255,0,0));
		menuBlockTop.setPreferredSize(new Dimension(400, 75));
		
		JPanel menuBlockBottom = new JPanel();
//		menuBlockBottom.setLayout(new GridBagLayout());
		menuBlockBottom.setBackground(new Color(255,0,0));
		menuBlockBottom.setPreferredSize(new Dimension(400, 75));
		
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(200, 400));
		left.setBackground(new Color(0,255,0));
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(200, 400));
		right.setBackground(new Color(0,255,0));
		
		
		JLabel time = new JLabel("Zeit in Sekunden");
		time.setPreferredSize(new Dimension(150, 75));
		JTextField timeInput = new JTextField();
		timeInput.setPreferredSize(new Dimension(150, 75));
		menuPanel.add(time);
		menuPanel.add(timeInput);

		JLabel text = new JLabel("Wie hei�t die 2. Schicht des Osi-Modells");
		text.setPreferredSize(new Dimension(150, 75));
		JTextField textInput = new JTextField();
		textInput.setPreferredSize(new Dimension(150, 75));
		menuPanel.add(text);
		menuPanel.add(textInput);

		JLabel correctIndex = new JLabel("Richtige Antowrt Index");
		correctIndex.setPreferredSize(new Dimension(150, 75));
		JTextField correctIndexInput = new JTextField();
		correctIndexInput.setPreferredSize(new Dimension(150, 75));
		menuPanel.add(correctIndex);
		menuPanel.add(correctIndexInput);

		JLabel antworten = new JLabel("Antworten");
		antworten.setPreferredSize(new Dimension(150, 75));
		JTextField antwortenInput = new JTextField();
		antwortenInput.setPreferredSize(new Dimension(150, 75));
		menuPanel.add(antworten);
		menuPanel.add(antwortenInput);

		JLabel textForPhoneJoker = new JLabel("Ja also ich denke das antwort B richtig ist. Davon habe ich schonmal geh�rt");
		textForPhoneJoker.setPreferredSize(new Dimension(150, 75));
		JTextField textForPhoneJokerInput = new JTextField();
		textForPhoneJokerInput.setPreferredSize(new Dimension(150, 75));
		menuPanel.add(textForPhoneJoker);
		menuPanel.add(textForPhoneJokerInput);
		
		pane.add(BorderLayout.WEST, left);
		pane.add(BorderLayout.CENTER, menuPanel);
		pane.add(BorderLayout.EAST, right);
		pane.add(BorderLayout.PAGE_END, menuBlockBottom);
		pane.add(BorderLayout.PAGE_START, menuBlockTop);
	}
	
	public void showForm() {
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
