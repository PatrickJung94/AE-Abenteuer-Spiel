package wwae;

import java.util.Iterator;
import java.util.Random;

public class Question {
	private double time;
	private String text;
	private String[] answers;
	
	// Joker related
	private int correctIndex;
	private String textForPhoneJoker;
	private String textForAdditionalJoker;
	
	// TODO: place the highest number where correctIndex is located in the array
	public double[] generateAudiencePercentage(Question question) {
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
				double tempPercentage = percentages[question.correctIndex];
				percentages[question.correctIndex] = max;
				percentages[indexOfMaxValue] = tempPercentage;
			}

	    return percentages;
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

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public Question() {
		this.setTime(0.0);
		this.setText("");
		this.setTextForPhoneJoker("");
		this.setCorrectIndex(0);
		this.setAnswers(new String[4]);
	}
}
