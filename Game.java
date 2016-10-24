package Implementation;

public class Game {

	private final Board board;

	public Game(Board board) {
		this.board=board;
	}

	public Board nextIteration() {
		return new Board();
	}

}

