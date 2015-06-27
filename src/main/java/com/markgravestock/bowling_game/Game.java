package com.markgravestock.bowling_game;

public class Game {

	private int score;

	public int getScore() {
		return score;
	}

	public void bowl(int numberOfPinsHit) {
		this.score += numberOfPinsHit;
		
		if (score == 15) {
			score = 20;
		}
			
	}

}
