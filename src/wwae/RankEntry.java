package wwae;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class RankEntry extends JFrame {


    private int score; 
    private JLabel highscore = new JLabel(); 
    private JTextField nameInput = new JTextField();
    private JButton save = new JButton("Anlegen");

    private FileSystem fs = new FileSystem();
    private AellionaerGame gameContext;

    RankEntry(AellionaerGame _gameContext){
        this.gameContext = _gameContext;
        init(); 
    }


    private void init(){
        setLocation(200, 200);
        Container pane = this.getContentPane();
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.highscore.setPreferredSize(new Dimension(200, 50));
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(highscore); 
        pane.add(new JLabel("Name:"));
        pane.add(nameInput);
        pane.add(save);

        save.addActionListener((event) -> {
            Rank r = new Rank(nameInput.getText(), this.score);
            fs.addRankingEntry(r);
            this.gameContext.addRankToMenu();
        });

    }

    
	public void showEntry(int _score) {
        this.score = _score;
        this.highscore.setText("erreichter Score: "+_score);
		this.setVisible(true);
		this.setResizable(false);
        this.pack();
	}
	
	public void hideEntry() {
		this.setVisible(false);
	}

	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
