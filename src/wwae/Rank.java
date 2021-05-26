package wwae;

public class Rank {

    private String name;
    private int score;

    public Rank (String _name, int _score) {
        this.setName(_name);
        this.setScore(_score);
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

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        if(score >= 0) {
            this.score = score;
        } else {
            this.score = 0;
        }
    }
    
}