package org.reydiazz.core;

public class Score {
    private int bestScore = 0;
    private int score = 0;

    public int updateBestScore() {
        if (score > bestScore) {
            bestScore = score;
        }
        return bestScore;
    }

    public void updateScore(int sum){
        this.score += sum;
    }

    public void resetScore(){
        this.score = 0;
    }

    public void resetBestScore(){
        this.bestScore = 0;
    }

    public int getScore() {
        return score;
    }

    public int getBestScore() {
        return bestScore;
    }

}
