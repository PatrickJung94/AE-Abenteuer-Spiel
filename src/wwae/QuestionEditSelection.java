package wwae;

import java.awt.event.WindowEvent;
import java.awt.Container;
import java.awt.*;
import javax.swing.*;

public class QuestionEditSelection extends JFrame {
    private static final long serialVersionUID = 1L;
    private AellionaerGame gameContext;
    private CreateQuestion createQuestion;

    public QuestionEditSelection(AellionaerGame _gameContext, int locationX, int locationY) {
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

        JButton add = new JButton("Fragen anlegen");
        add.setPreferredSize(new Dimension(200, 66));
        JButton delete = new JButton("Fragen loeschen");
        delete.setPreferredSize(new Dimension(200, 66));
        JButton edit = new JButton("Fragen bearbeiten");
        edit.setPreferredSize(new Dimension(200, 66));

        buttons.add(add, BorderLayout.NORTH);
        buttons.add(delete, BorderLayout.CENTER);
        buttons.add(edit, BorderLayout.SOUTH);

        add.addActionListener(event -> {
            createQuestion = new CreateQuestion();
			createQuestion.showForm();
            gameContext.updateQEMenuState();
            this.hideQESelection();
		});

        delete.addActionListener(event -> {
            QuestionSelectionDel questionDel = new QuestionSelectionDel(gameContext);
            questionDel.showQuestionSelection();
            gameContext.updateQEMenuState();
            this.hideQESelection();
		});

        edit.addActionListener(event -> {
            QuestionSelectionEdit questionEdit = new QuestionSelectionEdit(gameContext);
            questionEdit.showQuestionSelection();
            gameContext.updateQEMenuState();
            this.hideQESelection();
		});

        pane.add(buttons);
    }

    public void showQESelection() {
		this.setSize(200, 200);
		this.setVisible(true);
		this.setResizable(false);
	}

    public void hideQESelection() {
		this.setVisible(false);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
