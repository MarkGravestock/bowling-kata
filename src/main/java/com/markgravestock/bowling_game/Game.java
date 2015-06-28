package com.markgravestock.bowling_game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int SPARE_SCORE = 10;
	private static final int STRIKE_SCORE = 10;

	private List<Integer> pins = new ArrayList<Integer>();

	public int getScore() {
		int score = 0;
		int index = 0;

		for (int frame = 0; frame < 10; frame++) {

			int frameScore = calculateFrameScore(index);

			score += frameScore;

			if (isStrike(pins.get(index))) {
				score += calculateStrikeBonus(index);
				index = index + 1;
			} else if (isSpare(frameScore)) {
				score += calculateSpareBonus(index);
				index = index + 2;
			}
			else {
				index = index + 2;				
			}
		}

		return score;
	}

	private Integer calculateSpareBonus(int index) {
		return pins.get(index + 2);
	}

	private int calculateStrikeBonus(int index) {
		return pins.get(index + 2) + pins.get(index + 3);
	}

	private int calculateFrameScore(int index) {
		return pins.get(index) + pins.get(index + 1);
	}

	private boolean isStrike(int firstBowlInFrameScore) {
		return firstBowlInFrameScore == STRIKE_SCORE;
	}

	private boolean isSpare(int frameScore) {
		return frameScore == SPARE_SCORE;
	}

	public void bowl(int numberOfPinsHit) {
		pins.add(numberOfPinsHit);
	}
}
