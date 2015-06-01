package model;

import java.awt.Point;
import java.util.ArrayList;

public class Torre extends Piece {

	private ArrayList<Point> moves;

	public Torre(Team team, String imagePath) {
		super(team, imagePath);
		this.moves = new ArrayList<Point>();
	}

	@Override
	public ArrayList<Point> getMoves(int x, int y) {
		this.moves.clear();

		for (int i = 0; i < CHESSBOARD_ROW; i++) {
			if (i != y) {
				this.moves.add(new Point(x, i));
			}
		}
		
		for (int i = 0; i < CHESSBOARD_COL; i++) {
			if (i != x) {
				this.moves.add(new Point(i, y));
			}
		}

		return this.moves;
	}
}
