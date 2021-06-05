package wwae;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.border.AbstractBorder;
import java.awt.*;



import javax.swing.*;

public class SpielPanel extends JFrame {

	private AellionaerGame gameContext;
	private static final long serialVersionUID = 1L;
	JPanel answers = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel questionPanel = new JPanel();
	JLabel questionLabel = new JLabel();
	JPanel listenPanel = new JPanel();
	JPanel jokerPanel = new JPanel();
	JPanel leiterPanel = new JPanel();
	JPanel menuePanel = new JPanel();
	JPanel eventAlert = new JPanel();
	JLabel selectedJokerLabel = new JLabel();
	
	


	Timer timer = new Timer();
	private FileSystem fs = new FileSystem();
	private ArrayList<Question> questionsBundleArray; 
	private boolean joker50Used = false; 
	private boolean jokerTelefonUsed = false; 
	
	String question = new String();
	JButton[] buttons = new JButton[4];

	Font f = new Font(Font.SERIF, Font.BOLD, 50);
	Font f2 = new Font(Font.SERIF, Font.BOLD, 20);
	BoxLayout boxLayout = new BoxLayout(listenPanel, BoxLayout.Y_AXIS);
	FlowLayout flowLayoutJoker = new FlowLayout(); 
	FlowLayout flowLayoutLeiter = new FlowLayout();
	FlowLayout flowLayoutMenue = new FlowLayout();
	
	JButton joker50 = new JButton("50/50");
	JButton jokerTelefon = new JButton("Telefonjoker");
	JButton jokerPublikum = new JButton("Publikumsjoker");
	//JButton jokerz = new JButton("zjoker");
	
	public SpielPanel(AellionaerGame _gameContext) {
		super("Men\u00fc- Wer wird AEllion\u00e4r");
		gameContext = _gameContext;
		init();
	}

	private void init() {

		//eventAlert.setBackground(new Color(255,0,0));
		eventAlert.setLayout(new GridBagLayout());
		selectedJokerLabel.setFont(f2);
		eventAlert.add(selectedJokerLabel);

		infoPanel.setBackground(new Color(0,0,139));

		AbstractBorder border = new TextBubbleBorder(new Color(0, 0, 0),1,30,0);
		
		joker50.setBorder(border);
		jokerTelefon.setBorder(border);
		jokerPublikum.setBorder(border);
		//jokerz.setBorder(border);
		
		jokerTelefon.setPreferredSize(new Dimension(300,100));
		joker50.setPreferredSize(new Dimension(300,100));
		jokerPublikum.setPreferredSize(new Dimension(300,100));
		//jokerz.setPreferredSize(new Dimension(300,100));
		this.questionLabel = new JLabel(question,SwingConstants.CENTER);
		setQuestion("sdhjkdshksdjh");
		
		


		answers.setLayout(new GridLayout(2, 2));
		answers.setPreferredSize(new Dimension(1280, 220));
		
		
		for (int i = 0; i < 4; i++) {
			String[] buttonsArray = new String[4];
			buttons[i] = new JButton(buttonsArray[i]);
			answers.add(buttons[i]);
		}

		buttons[0].setBorder(border);
		buttons[1].setBorder(border);
		buttons[2].setBorder(border);
		buttons[3].setBorder(border);

		
		flowLayoutMenue.setHgap(500);
		menuePanel.setLayout(flowLayoutMenue);
		
		JButton zurueckButton = new JButton("Zurück");
		JButton beendenButton = new JButton("Beenden");
		JProgressBar timerProgressBar = new JProgressBar();

		menuePanel.add(zurueckButton);
		menuePanel.add(timerProgressBar);
		menuePanel.add(beendenButton);

		zurueckButton.addActionListener(event -> {
			gameContext.gamePanelToMenu();
		});

		beendenButton.addActionListener(event -> {
			System.exit(0);
		});

		

		
		
		questionLabel.setFont(f);
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(menuePanel, BorderLayout.NORTH);
		infoPanel.add(jokerPanel, BorderLayout.WEST);
		infoPanel.add(leiterPanel, BorderLayout.EAST);
		infoPanel.add(questionPanel, BorderLayout.SOUTH);
		infoPanel.add(eventAlert, BorderLayout.CENTER);

		leiterPanel.setLayout(flowLayoutLeiter);
		leiterPanel.setPreferredSize(new Dimension(400,500));
		
		int i=10;
		JButton[] labels = new JButton[11];  
		while (i>0) {
			labels[i] = new JButton(String.valueOf(i*10));
			labels[i].setPreferredSize(new Dimension(300,60));
			leiterPanel.add(labels[i]);
			labels[i].setBorder(border);
			i=i-1;
		}


		
		jokerPanel.setPreferredSize(new Dimension(400,500));
		jokerPanel.setLayout(flowLayoutJoker);
		jokerPanel.add(joker50);
		jokerPanel.add(jokerTelefon);
		jokerPanel.add(jokerPublikum);
		//jokerPanel.add(jokerz);

		questionPanel.add(questionLabel);

	
		
		
		listenPanel.setLayout(boxLayout);
		listenPanel.add(Box.createRigidArea(new Dimension(3, 1)));
		listenPanel.add(infoPanel);
		listenPanel.add(answers);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(listenPanel);
		this.setPreferredSize(new Dimension(1000, 1000));
		joker50.addActionListener((event)->{


			if(!joker50Used){
				int[] correctIndexes = questionsBundleArray.get(0).generateFiftyFiftyOutcome();
				System.out.println(correctIndexes[0]);
				System.out.println(correctIndexes[1]);

				// ArrayList<Integer> wrongIndexes = new ArrayList<>();
				// for(int k=0; k<4;k++){

				// 	for(int l=0; l<correctIndexes.length;l++){
				// 		if(correctIndexes[l] != k){

				// 		}
				// 	}

				// }
				
				for(int t=0; t<4;t++ ){
	
					buttons[t].hide();
				}


				for(int j=0; j<2;j++ ){
	
					buttons[correctIndexes[j]].show();
				}
				joker50Used = true;

			}



		});

		jokerTelefon.addActionListener((event2)->{

			if(!jokerTelefonUsed){
				String telefonJoker = this.questionsBundleArray.get(0).getTextForPhoneJoker();
				System.out.println("Telefonjoker: "+telefonJoker);
				this.selectedJokerLabel.setText(telefonJoker);
				jokerTelefonUsed = true; 
			}
				

		});
	}

	public void setAnswerPossibilities(String [] answers) {
	
		buttons[0].setText(answers[0]);
		buttons[1].setText(answers[1]);
		buttons[2].setText(answers[2]);
		buttons[3].setText(answers[3]);

	}

	public void setQuestion(String question) {
	
		this.questionLabel.setText(question);
	}
	
	public void showGamePanel(String bundleName) {

        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setResizable(false);
		this.questionsBundleArray = fs.getAllQuestionsFromBundle(bundleName);
		this.setQuestion(questionsBundleArray.get(0).getText());
		this.setAnswerPossibilities(questionsBundleArray.get(0).getAnswers());
		System.out.println("Size: "+ questionsBundleArray.get(0).getText());
		System.out.println("Size: "+ questionsBundleArray.get(0).getAnswers()[0].toString());
    }

	// private void loadQuestions(){
	// }


    public void hideGamePanel() {
        this.setVisible(false);
    }

    public void close() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }




}
