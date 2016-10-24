
package test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Implementation.Board;
import Implementation.cell;

import static org.junit.Assert.assertArrayEquals;

public class test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Single_cel_Should_have_zero_neighbours() {
		Board board = new Board();
		board.addcell(new cell(0, 0));

		Set<cell> neighbours = board.getNeighbours(new cell(0, 0));

		assertEquals(0, neighbours.size());

	}

	@Test
	public void Two_cells_next_to_eachOther_should_be_neighbours() {
		Board board = new Board();
		cell first = new cell(0, 0);
		board.addcell(first);
		cell second = new cell(0, 1);
		board.addcell(second);

		Set<cell> neighbouroffirstcell = board.getNeighbours(first);
		Set<cell> neighbourofsecondcell = board.getNeighbours(second);

		assertArrayEquals(new cell[] { second }, neighbouroffirstcell.toArray());
		assertArrayEquals(new cell[] { first }, neighbourofsecondcell.toArray());

	}

	@Test
	public void Two_single_cells_far_frm_each_other_should_have_zero_neighbours() {
		Board board = new Board();
		board.addcell(new cell(0, 0));
		board.addcell(new cell(0, 100));

		Set<cell> neighbours = board.getNeighbours(new cell(0, 0));

		assertEquals(0, neighbours.size());

	}

	@Test
	public void middleCell_of_3X3_block_shouldHave_8_neigbours() {
		Board board = createBlockBoard(3,3);

		Set<cell> neighbours = board.getNeighbours(new cell(1, 1));

		assertEquals(8, neighbours.size());

	}

	private Board createBlockBoard(int width, int hight) {
		Board board = new Board();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				board.addcell(new cell(i, j));
			}

		}
		return board;
	}

}
