package com.markgravestock.bowling_game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.markgravestock.bowling_game.Game;

import static org.hamcrest.CoreMatchers.*;

public class ScoringTests {

	@Test
	public void bowlingOneBowlThatIsntAStrike() {
		Game game = new Game();
		game.bowl(1);
		assertThat(game.getScore(), is(equalTo(1)));
	}
	
	@Test
	public void bowlingTwoScoresTwo() throws Exception {
		Game game = new Game();
		game.bowl(2);
		assertThat(game.getScore(), is(equalTo(2)));
	}

	@Test
	public void bowlingTwoBowlsThatArentASpare() throws Exception {
		Game game = new Game();
		game.bowl(1);
		game.bowl(4);
		assertThat(game.getScore(), is(equalTo(5)));
	}
	
	@Test
	public void bowlingASpare() throws Exception {
		Game game = new Game();
		game.bowl(6);
		game.bowl(4);
		game.bowl(5);
		assertThat(game.getScore(), is(equalTo(20)));
	}
}
