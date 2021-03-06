// Source for Bargraph: https://gist.github.com/landone911/4b57cbbde560ae2e7bfadacce1075a04

package wwae;

import java.util.Iterator;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question {
	private String text;
	private String[] answers;
	
	// Joker related
	private int correctIndex;
	private Difficulty difficulty;
	private String textForPhoneJoker;
	
	public double[] generateAudiencePercentage() {
		Random rand = new Random();
		double[] percentages = new double[4];
		double sum = 0;

	    for (int i = 0; i < percentages.length; i++) {
	    	percentages[i] = rand.nextDouble();
	        sum += percentages[i];
	    }
			double max = 0;
			int indexOfMaxValue = 0;
	    for (int i = 0; i < percentages.length; i++) {
	    	percentages[i] = Math.round(percentages[i] / sum * 100);
				if (percentages[i] > max) {
					max = percentages[i];
					indexOfMaxValue = i;
				}
	    }

			if (correctIndex != indexOfMaxValue) {
				double tempPercentage = percentages[this.correctIndex];
				percentages[this.correctIndex] = max;
				percentages[indexOfMaxValue] = tempPercentage;
			}

	    return percentages;
	}

	public int[] generateFiftyFiftyOutcome () {
		Random rand = new Random();
		int[] outcomes = new int[2];
		int otherIndex = -1;

		do {
			otherIndex = rand.nextInt(4);
		} while (otherIndex == this.correctIndex && otherIndex > -1 );

		outcomes[0] = correctIndex;
		outcomes[1] = otherIndex;

		return outcomes;
	}

	public JPanel generateBargraphForAudienceJoker() {
		JPanel barPanel;

		barPanel = new JPanel();
		barPanel.setSize(400, 400);
		barPanel.setPreferredSize(barPanel.getSize());
		barPanel.add(new DrawBars(barPanel.getSize(), this.generateAudiencePercentage()));

		return barPanel;
	}

	public static class DrawBars extends JPanel  implements MouseListener {
		private int x = 20;
		private int y = 200;

		private double answer1;
		private double answer2;
		private double answer3;
		private double answer4;        
		

		public DrawBars(Dimension dimension, double[] answerValues) {
				setSize(dimension);
				setPreferredSize(dimension);
				addMouseListener(this);
				answer1 = answerValues[0];
				answer2 = answerValues[1];
				answer3 = answerValues[2];
				answer4 = answerValues[3];
		}

		@Override
		public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D)g;  //g2 is the graphics object that we need to use
																				//to draw things to the screen
				Dimension d = getSize();
				//create a background
				g2.setColor(Color.white);
				g2.fillRect(0, 0, d.width, d.height);
				

				Color purple = new Color(102,0, 102); 
				Color green = new Color(6,153,61);
				Color red = new Color(220,20,60); 
				Color blue = new Color(65,105,225);

				g2.setColor(purple);
				g2.fillRect(30 + 10, 360-(int)(answer1 * 2),48,(int)(answer1 * 200));
				g2.drawString(answer1 + "%" ,  35 + 10, 360-(int)(answer1 * 2 + 10));

				g2.setColor(green);
				g2.fillRect(30 + 100, 360-(int)(answer2 * 2),48,(int)(answer2 * 200));
				g2.drawString(answer2 + "%" ,  35 + 100, 360-(int)(answer2 * 2 + 10));
				
				g2.setColor(red);
				g2.fillRect(30 + 190, 360-(int)(answer3 * 2),48,(int)(answer3 * 200));
				g2.drawString(answer3 + "%" ,  35 + 190, 360-(int)(answer3 * 2 + 10));
				
				g2.setColor(blue);
				g2.fillRect(30 + 280, 360-(int)(answer4 * 2),48,(int)(answer4 * 200));
				g2.drawString(answer4 + "%" ,  35 + 280, 360-(int)(answer4 * 2 + 10));

										
				g2.setColor(purple);
				g2.setFont (new Font("Arial", Font.PLAIN, 20));
				g2.drawString("A" ,  55,30);//text to display, x and y coordinates
				g2.setColor(green);
				g2.drawString("B" ,  145,30);
				g2.setColor(red);
				g2.drawString("C" ,  235,30);
				g2.setColor(blue);
				g2.drawString("D" ,  325,30);

		}
		public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY(); 

				repaint();
		}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mouseClicked(MouseEvent e) {}
	}
	public String getTextForPhoneJoker() {
		return textForPhoneJoker;
	}

	public void setTextForPhoneJoker(String textForPhoneJoker) {
		this.textForPhoneJoker = textForPhoneJoker;
	}

	public int getCorrectIndex() {
		return correctIndex;
	}

	public void setCorrectIndex(int correctIndex) {
		this.correctIndex = correctIndex;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question() {
		this.setText("");
		this.setTextForPhoneJoker("");
		this.setCorrectIndex(2);
		this.setAnswers(new String[4]);
	}
}
