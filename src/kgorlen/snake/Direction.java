package kgorlen.snake;

public enum Direction {
	LEFT 	(-SnakeController.CellSize, 0),
	RIGHT 	(+SnakeController.CellSize, 0),
	UP 		(0, -SnakeController.CellSize),
	DOWN 	(0, +SnakeController.CellSize);
	
	private final int x,y;
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public final int x() { return x; }
	public final int y() { return y; }
}
