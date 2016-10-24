package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Implementation.Board;
import Implementation.Game;
import Implementation.cell;

public class GameOfLifetest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void aSingle_cell_shouldDie_inNext_iteration() {
		
		Board board= new Board();
		board.addcell(new cell(0,0));	
		Game game= new Game(board);
		
		Board nextboard=game.nextIteration();
		
		assertFalse(nextboard.isCellAlive(new cell(0,0)));
	}
	
	@Test
	private void aCell_with_Two_neighbours_should_be_alive_in_theNextIteration() {
		Board board= new Board();
		board.addcell(new cell(0,1));
		board.addcell(new cell(1,1));
		board.addcell(new cell(1,0));
		Game game= new Game(board);
		
		Board nextboard=game.nextIteration();
		assertTrue(nextboard.isCellAlive(new cell(1,1)));
		
		
		
	}

}
