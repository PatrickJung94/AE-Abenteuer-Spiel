package wwae;

import java.awt.event.WindowEvent;
import java.awt.Container;
import java.awt.*;
import javax.swing.*;

public class DifficultySelection extends JFrame {
    private static final long serialVersionUID = 1L;
    private AellionaerGame gameContext;

    public DifficultySelection(AellionaerGame _gameContext, int locationX, int locationY) {
        super("Schwierigkeitsgrad ausw\u00e4hlen");
        gameContext = _gameContext;
        setLocation(locationX, locationY);
        createLayout();
    }

    private void createLayout() {
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        this.setUndecorated(true);

        Container pane = this.getContentPane();

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());

        JButton low = new JButton("Leicht");
        low.setPreferredSize(new Dimension(200, 66));
        JButton medium = new JButton("Mittel");
        medium.setPreferredSize(new Dimension(200, 66));
        JButton hard = new JButton("Schwer");
        hard.setPreferredSize(new Dimension(200, 66));

        buttons.add(low, BorderLayout.NORTH);
        buttons.add(medium, BorderLayout.CENTER);
        buttons.add(hard, BorderLayout.SOUTH);

        low.addActionListener(event -> {
			gameContext.changeDifficulty(Difficulty.LOW);;
            this.hideDifficultySelection();
		});

        medium.addActionListener(event -> {
			gameContext.changeDifficulty(Difficulty.MEDIUM);
            this.hideDifficultySelection();
		});

        hard.addActionListener(event -> {
			gameContext.changeDifficulty(Difficulty.HARD);
            this.hideDifficultySelection();
		});

        pane.add(buttons);
    }

    public void showDifficultySelection() {
		this.setSize(200, 200);
		this.setVisible(true);
		this.setResizable(false);
	}

    public void hideDifficultySelection() {
		this.setVisible(false);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
