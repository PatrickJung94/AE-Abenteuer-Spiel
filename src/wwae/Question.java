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
	
	// TODO: place the highest number where correctIndex is located in the array
	public double[] generateAudiencePercentage(Question question) {
		Random rand = new Random();
		double[] percentages = new double[4];
		double sum = 0;

	    for (int i = 0; i < percentages.length; i++) {
	    	percentages[i] = rand.nextDouble();
	        sum += percentages[i];
	    }

	    for (int i = 0; i < percentages.length; i++) {
	    	percentages[i] = Math.round(percentages[i] / sum * 100);
	    }

	    return percentages;
	}
	
	public Question() {
		this.time = 0.0;
		this.text = "";
		this.textForPhoneJoker = "";
		this.correctIndex = 0;
		this.answers = new String[4];
	}
}
