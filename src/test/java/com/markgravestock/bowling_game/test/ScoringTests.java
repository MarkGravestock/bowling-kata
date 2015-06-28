package com.markgravestock.bowling_game.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.util.stream.IntStream.*;

import org.junit.Ignore;
import org.junit.Test;

import com.markgravestock.bowling_game.Game;

public class ScoringTests {

	@Test
	public void playGutterGame() {
		Game game = new Game();
		
		range(0, 20).forEach(num -> game.bowl(0));
		
		assertThat(game.getScore(), is(equalTo(0)));
	}
	
	@Test
	public void rollAllOnes() {
		Game game = new Game();
		
		range(0, 20).forEach(num -> game.bowl(1));
		
		assertThat(game.getScore(), is(equalTo(20)));		
	}
	
	@Test
	public void rollOneSpare() {
		Game game = new Game();
		
		game.bowl(5);
		game.bowl(5);
		game.bowl(3);
		range(3, 20).forEach(num -> game.bowl(0));
		
		assertThat(game.getScore(), is(equalTo(16)));		
	}
	
	@Test
	public void rollOneStrike() {
		Game game = new Game();
		
		game.bowl(10);
		game.bowl(3);
		game.bowl(4);
		range(4, 20).forEach(num -> game.bowl(0));
		
		assertThat(game.getScore(), is(equalTo(24)));		
	}
	
	@Test
	public void playPerfectGame() {
		Game game = new Game();
		
		range(0, 12).forEach(num -> game.bowl(10));
		
		assertThat(game.getScore(), is(equalTo(300)));
	}
	
}
