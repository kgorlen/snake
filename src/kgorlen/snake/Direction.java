package kgorlen.snake;

public enum Direction {
	LEFT 	(-SnakeController.CELL_SIZE, 0),
	RIGHT 	(+SnakeController.CELL_SIZE, 0),
	UP 		(0, -SnakeController.CELL_SIZE),
	DOWN 	(0, +SnakeController.CELL_SIZE);
	
	private final int x,y;
	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public final int x() { return x; }
	public final int y() { return y; }
}
