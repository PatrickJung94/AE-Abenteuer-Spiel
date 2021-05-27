package wwae;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rank {

    private String name;
    private int score;
    private Date timestamp;

    public Rank (String _name, int _score, Date _timestamp) {
        this.setName(_name);
        this.setScore(_score);
        this.setTimestamp(_timestamp);
    }

    public Rank (String _name, int _score) {
        this.setName(_name);
        this.setScore(_score);
        this.setTimestamp(new Date());
    }

    public void increaseScore(int amount) {
        this.score += amount;
    }

    public void decreaseScore(int amount) {
        if (this.score - amount >= 0) {
            this.score -= amount;
        }
    }

    public boolean matches(String _name) {
        return this.name.equalsIgnoreCase(_name);
    }

    public String getTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        return formatter.format(this.timestamp);
    }

    public void setTimestamp(Date _timestamp) {
        this.timestamp = _timestamp;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String _name) {
        this.name = _name;
    }

    public int getScore() {
        return this.score;
    }

    private void setScore(int _score) {
        if(score >= 0) {
            this.score = _score;
        } else {
            this.score = 0;
        }
    }
    
}