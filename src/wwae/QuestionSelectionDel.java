package wwae;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.*;
import javax.swing.*;

public class QuestionSelectionDel extends JFrame {

    private AellionaerGame gameContext;
    private JScrollPane selPanel;
    private FileSystem fs = new FileSystem();
    private ArrayList<Question> questions;
    private JList questionList;

    public QuestionSelectionDel(AellionaerGame _gameContext) {
        super("Fragen loeschen aus Bundle: " + _gameContext.getActiveBundle());
        gameContext = _gameContext;
        questions = fs.getAllQuestionsFromBundle(gameContext.getActiveBundle());
        this.renderQuestionList();
        this.createLayout();
    }

    private void createLayout() {
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocation(390, 450);

        Container pane = this.getContentPane();

        JPanel selection = new JPanel();
        
        selPanel = new JScrollPane(questionList);
        selPanel.setPreferredSize(new Dimension(700, 400));
        selection.add(selPanel);

        JButton delete = new JButton("Loeschen");

        delete.addActionListener(event -> {
            DefaultListModel model = (DefaultListModel) questionList.getModel();
            int selectedIndex = questionList.getSelectedIndex();
            if (selectedIndex != -1 && questions.size() > 1) {
                Question q = questions.get(questionList.getSelectedIndex());
                questions.remove(q);
                model.remove(selectedIndex);
                fs.rewriteBundle(questions, "ae");
            }
        });

        pane.add(BorderLayout.CENTER, selection);
        pane.add(BorderLayout.SOUTH, delete);
    }

    public void showQuestionSelection() {
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

    public void hideQuestionSelection() {
		this.setVisible(false);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

    private void renderQuestionList() {
        ArrayList<String> questionTextList = new ArrayList<String>();
        for (Question q : questions) {
            questionTextList.add(q.getText());
        }

        DefaultListModel lm = new DefaultListModel();
        for (String q : questionTextList) {
            lm.add(lm.getSize(), q);
        }
        

        questionList = new JList(lm);
        questionList.setLayoutOrientation(JList.VERTICAL);
    }
}
