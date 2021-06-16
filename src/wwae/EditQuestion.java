package wwae;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import wwae.Question;

public class EditQuestion extends JFrame {
	// add import of file
	private FileSystem fileSystem = new FileSystem();
	private AellionaerGame gameContext;
	private ArrayList<Question> bundleQuestions;

	int questionIndex;

	private Question question;
	private JTextField textInput = new JTextField();
	private JTextField antwort1Input = new JTextField();
	private JTextField antwort2Input = new JTextField();
	private JTextField antwort3Input = new JTextField();
	private JTextField antwort4Input = new JTextField();
	private JTextField textForPhoneJokerInput = new JTextField();

	String[] correctIndexes = { "Antwort 1", "Antwort 2", "Antwort 3", "Antwort 4" };
	JComboBox correctIndexInput = new JComboBox(correctIndexes);

	String[] difficultyOptions = { "Leicht", "Mittel", "Schwer" };
	JComboBox difficultyInput = new JComboBox(difficultyOptions);

	public EditQuestion(Question _question, ArrayList<Question> _bundleQuestions, AellionaerGame _gameContext) {
		super("Frage bearbeiten (in Bundle: "+ _gameContext.getActiveBundle() +") - Wer wird AEllion\u00e4r");
		gameContext = _gameContext;
		question = _question;
		bundleQuestions = _bundleQuestions;
		questionIndex = bundleQuestions.indexOf(question);
		createForm();
	}
	
	private void createForm() {
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

		Container pane = this.getContentPane(); 

		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(5, 2));
		
		JPanel menuBlockTop = new JPanel();
		menuBlockTop.setBackground(new Color(220,220,220));
		menuBlockTop.setPreferredSize(new Dimension(400, 75));

		JLabel title = new JLabel("Frage bearbeiten");
		Font currentFont = title.getFont();
		title.setFont(
			new Font(currentFont.getName(),
			currentFont.getStyle(),
			currentFont.getSize() * 2
		));
		title.setPreferredSize(new Dimension(300, 50));
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(220,220,220));
		titlePanel.add(title);
		menuBlockTop.add(titlePanel);
		
		JPanel menuBlockBottom = new JPanel();
		menuBlockBottom.setBackground(new Color(220,220,220));
		menuBlockBottom.setPreferredSize(new Dimension(400, 75));

		JButton saveButton = new JButton("Speichern");
		menuBlockBottom.add(saveButton);

		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(200, 400));
		left.setBackground(new Color(220,220,220));
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(200, 400));
		right.setBackground(new Color(220,220,220));

		// ---------- Load Question -----------
		this.textInput.setText(question.getText());
		this.antwort1Input.setText(question.getAnswers()[0]);
		this.antwort2Input.setText(question.getAnswers()[1]);
		this.antwort3Input.setText(question.getAnswers()[2]);
		this.antwort4Input.setText(question.getAnswers()[3]);
		this.textForPhoneJokerInput.setText(question.getTextForPhoneJoker());
		this.correctIndexInput.setSelectedIndex(question.getCorrectIndex());
		switch (question.getDifficulty()) {
			case LOW:
				this.difficultyInput.setSelectedIndex(0);
				break;
			case MEDIUM:
				this.difficultyInput.setSelectedIndex(1);
				break;
			case HARD:
				this.difficultyInput.setSelectedIndex(2);
				break;
		}

		// ---------- Create Row for question text Input -----------

		JPanel difficultyPanel = new JPanel();
		JLabel difficulty = new JLabel("Schwierigkeitsgrad: ");
		difficulty.setPreferredSize(new Dimension(150, 30));

		JPanel difficultyInputPanel = new JPanel();
		difficultyInput.setPreferredSize(new Dimension(300, 30));
		difficultyInput.addActionListener((event) -> {
			JComboBox cb = (JComboBox)event.getSource();
			this.setQuestionDifficulty(cb);
		});

		difficultyPanel.add(difficulty);
		difficultyInputPanel.add(difficultyInput);
		menuPanel.add(difficultyPanel);
		menuPanel.add(difficultyInputPanel);

		// ---------- Create Row for question text Input -----------

		JPanel textPanel = new JPanel();
		JLabel text = new JLabel("Frage: ");
		text.setPreferredSize(new Dimension(150, 30));

		JPanel textInputPanel = new JPanel();
		textInput.setPreferredSize(new Dimension(300, 30));

		textPanel.add(text);
		textInputPanel.add(textInput);
		menuPanel.add(textPanel);
		menuPanel.add(textInputPanel);

		// ---------- Create Row for correct answer index Input -----------

		
		JPanel correctIndexPanel = new JPanel();
		JLabel correctIndex = new JLabel("Richtige Antwort Index");
		correctIndex.setPreferredSize(new Dimension(150, 30));
		
		JPanel correctIndexInputPanel = new JPanel();
		correctIndexInput.setPreferredSize(new Dimension(300, 30));
		correctIndexInput.addActionListener((event) -> {
			JComboBox cb = (JComboBox)event.getSource();
			question.setCorrectIndex(cb.getSelectedIndex());
		});

		correctIndexPanel.add(correctIndex);
		correctIndexInputPanel.add(correctIndexInput);
		menuPanel.add(correctIndexPanel);
		menuPanel.add(correctIndexInputPanel);

		// ---------- Create Row for answer Inputs -----------

		JPanel antwortenPanel = new JPanel();
		JLabel antworten = new JLabel("Antworten");
		antworten.setPreferredSize(new Dimension(150, 30));
		
		JPanel antwortenInputPanel = new JPanel();
		antwortenInputPanel.setPreferredSize(new Dimension(400, 100));
		antwortenInputPanel.setLayout(new GridLayout(4, 2));

		JPanel antwort1TextPanel = new JPanel();
		JLabel antwort1Text = new JLabel("Antwort 1");
		antwort1Text.setPreferredSize(new Dimension(100, 15));
		
		antwort1TextPanel.add(antwort1Text);
		JPanel antwort1Panel = new JPanel();
		antwort1Input.setPreferredSize(new Dimension(200, 15));
		antwort1Panel.add(antwort1Input);
		antwortenInputPanel.add(antwort1TextPanel);
		antwortenInputPanel.add(antwort1Panel);

		JPanel antwort2TextPanel = new JPanel();
		JLabel antwort2Text = new JLabel("Antwort 2");
		antwort2Text.setPreferredSize(new Dimension(100, 15));
		
		antwort2TextPanel.add(antwort2Text);
		JPanel antwort2Panel = new JPanel();
		antwort2Input.setPreferredSize(new Dimension(200, 15));
		antwort2Panel.add(antwort2Input);
		antwortenInputPanel.add(antwort2TextPanel);
		antwortenInputPanel.add(antwort2Panel);

		JPanel antwort3TextPanel = new JPanel();
		JLabel antwort3Text = new JLabel("Antwort 3");
		antwort3Text.setPreferredSize(new Dimension(100, 15));
		
		antwort3TextPanel.add(antwort3Text);
		JPanel antwort3Panel = new JPanel();
		antwort3Input.setPreferredSize(new Dimension(200, 15));
		antwort3Panel.add(antwort3Input);
		antwortenInputPanel.add(antwort3TextPanel);
		antwortenInputPanel.add(antwort3Panel);

		JPanel antwort4TextPanel = new JPanel();
		JLabel antwort4Text = new JLabel("Antwort 4");
		antwort4Text.setPreferredSize(new Dimension(100, 15));
		
		antwort4TextPanel.add(antwort4Text);
		JPanel antwort4Panel = new JPanel();
		antwort4Input.setPreferredSize(new Dimension(200, 15));
		antwort4Panel.add(antwort4Input);
		antwortenInputPanel.add(antwort4TextPanel);
		antwortenInputPanel.add(antwort4Panel);

		antwortenPanel.add(antworten);

		menuPanel.add(antwortenPanel);
		menuPanel.add(antwortenInputPanel);

		// ---------- Create Row for telephon joker Input -----------

		JPanel textForPhoneJokerPanel = new JPanel();
		JLabel textForPhoneJoker = new JLabel("Text für den Telefon Joker");
		textForPhoneJoker.setPreferredSize(new Dimension(150, 30));

		JPanel textForPhoneJokerInputPanel = new JPanel();
		textForPhoneJokerInput.setPreferredSize(new Dimension(300, 30));

		textForPhoneJokerPanel.add(textForPhoneJoker);
		textForPhoneJokerInputPanel.add(textForPhoneJokerInput);
		menuPanel.add(textForPhoneJokerPanel);
		menuPanel.add(textForPhoneJokerInputPanel);


		// ---------- Create save button action -----------

		saveButton.addActionListener((event) -> {			
			question.setText(textInput.getText());
			question.setCorrectIndex(correctIndexInput.getSelectedIndex());
			String[] temp = {
				antwort1Input.getText(),
				antwort2Input.getText(),
				antwort3Input.getText(),
				antwort4Input.getText()
			};
			question.setAnswers(temp);
			question.setTextForPhoneJoker(textForPhoneJokerInput.getText());

			bundleQuestions.remove(questionIndex);
			bundleQuestions.add(question);

			fileSystem.rewriteBundle(bundleQuestions, gameContext.getActiveBundle());

			this.hideForm();
		});
		
		
		pane.add(BorderLayout.WEST, left);
		pane.add(BorderLayout.CENTER, menuPanel);
		pane.add(BorderLayout.EAST, right);
		pane.add(BorderLayout.PAGE_END, menuBlockBottom);
		pane.add(BorderLayout.PAGE_START, menuBlockTop);
	}

	private void setQuestionDifficulty(JComboBox cb) {
		switch (cb.getSelectedItem().toString()) {
			case "Leicht":
				question.setDifficulty(Difficulty.LOW);
				break;
			case "Mittel":
				question.setDifficulty(Difficulty.MEDIUM);
				break;
			case "Schwer":
				question.setDifficulty(Difficulty.HARD);
				break;
		
			default:
				question.setDifficulty(Difficulty.LOW);
				break;
		}
	}
	
	public void showForm() {
		this.setSize(1280, 720);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void hideForm() {
		this.setVisible(false);
	}

	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
