package tests.helper;

import java.awt.Point;
import java.util.ArrayList;

import model.Piece.Team;

public class MovesTestHelper {

	public static final int POSITION_X = 4;
	public static final int POSITION_Y = 4;

	public static ArrayList<Point> getPawnMoves(Team team) {
		int x = POSITION_X;
		int y = POSITION_Y;
		ArrayList<Point> moves = new ArrayList<Point>();

		if (team.equals(Team.UP_TEAM)) {
			moves.add(new Point(x, y - 1));
		} else {
			moves.add(new Point(x, y + 1));
		}

		return moves;
	}

	public static ArrayList<Point> getTowerMoves() {
		int x = POSITION_X;
		int y = POSITION_Y;
		ArrayList<Point> moves = new ArrayList<Point>();

		moves.add(new Point(x - 4, y));
		moves.add(new Point(x - 3, y));
		moves.add(new Point(x - 2, y));
		moves.add(new Point(x - 1, y));
		moves.add(new Point(x + 1, y));
		moves.add(new Point(x + 2, y));
		moves.add(new Point(x + 3, y));
		moves.add(new Point(x, y - 4));
		moves.add(new Point(x, y - 3));
		moves.add(new Point(x, y - 2));
		moves.add(new Point(x, y - 1));
		moves.add(new Point(x, y + 1));
		moves.add(new Point(x, y + 2));
		moves.add(new Point(x, y + 3));

		return moves;
	}

	public static ArrayList<Point> getHorseMoves() {
		int x = POSITION_X;
		int y = POSITION_Y;
		ArrayList<Point> moves = new ArrayList<Point>();

		moves.add(new Point(x - 1, y + 2));
		moves.add(new Point(x + 1, y + 2));
		moves.add(new Point(x + 1, y - 2));
		moves.add(new Point(x - 1, y - 2));
		moves.add(new Point(x - 2, y + 1));
		moves.add(new Point(x - 2, y - 1));
		moves.add(new Point(x + 2, y + 1));
		moves.add(new Point(x + 2, y - 1));

		return moves;
	}

	public static ArrayList<Point> getBishopMoves() {
		int x = POSITION_X;
		int y = POSITION_Y;
		ArrayList<Point> moves = new ArrayList<Point>();

		moves.add(new Point(x - 1, y + 1));
		moves.add(new Point(x - 2, y + 2));
		moves.add(new Point(x - 3, y + 3));
		moves.add(new Point(x - 1, y - 1));
		moves.add(new Point(x - 2, y - 2));
		moves.add(new Point(x - 3, y - 3));
		moves.add(new Point(x + 1, y + 1));
		moves.add(new Point(x + 2, y + 2));
		moves.add(new Point(x + 3, y + 3));
		moves.add(new Point(x + 4, y + 4));
		moves.add(new Point(x + 1, y - 1));
		moves.add(new Point(x + 2, y - 2));
		moves.add(new Point(x + 3, y - 3));

		return moves;
	}

	public static ArrayList<Point> getKingMoves() {
		int x = POSITION_X;
		int y = POSITION_Y;
		ArrayList<Point> moves = new ArrayList<Point>();

		moves.add(new Point(x + 1, y + 1));
		moves.add(new Point(x + 0, y + 1));
		moves.add(new Point(x - 1, y + 1));
		moves.add(new Point(x - 1, y + 0));
		moves.add(new Point(x - 1, y - 1));
		moves.add(new Point(x + 0, y - 1));
		moves.add(new Point(x + 1, y - 1));
		moves.add(new Point(x + 1, y + 0));

		return moves;
	}
}
