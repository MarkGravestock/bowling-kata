package com.markgravestock.bowling_game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int SPARE_SCORE = 10;
	private static final int STRIKE_SCORE = 10;

	private List<Integer> rolls = new ArrayList<Integer>();

	public int getScore() {
		int score = 0;
		int rollIndex = 0;

		for (int frame = 0; frame < 10; frame++) {

			if (isStrike(rollIndex)) {
				score += STRIKE_SCORE;
				score += calculateStrikeBonus(rollIndex);
				rollIndex = rollIndex + 1;
			} else if (isSpare(rollIndex)) {
				score += SPARE_SCORE;
				score += calculateSpareBonus(rollIndex);
				rollIndex = rollIndex + 2;
			}
			else {
				score += calculateFrameScore(rollIndex);
				rollIndex = rollIndex + 2;				
			}
		}

		return score;
	}

	private boolean isStrike(int index) {
		return rolls.get(index) == STRIKE_SCORE;
	}

	private Integer calculateSpareBonus(int index) {
		return rolls.get(index + 2);
	}

	private int calculateStrikeBonus(int index) {
		return rolls.get(index + 1) + rolls.get(index + 2);
	}

	private int calculateFrameScore(int index) {
		return rolls.get(index) + rolls.get(index + 1);
	}

	private boolean isSpare(int index) {
		return calculateFrameScore(index) == SPARE_SCORE;
	}

	public void bowl(int numberOfPinsHit) {
		rolls.add(numberOfPinsHit);
	}
}
