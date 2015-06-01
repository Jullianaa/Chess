package model;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Piece {

	public static final int CHESSBOARD_ROW = 8;
	public static final int CHESSBOARD_COL = 8;

	private Team team;
	private String imagePath;
	public abstract ArrayList<Point> getMoves(int x, int y);

	public static enum Team {
		UP_TEAM, DOWN_TEAM;
	}

	public Piece(Team team) {
		this.team = team;
	}

	public Piece(String imagePath) {
		super();
		this.imagePath = imagePath;
	}
	
	public Piece(Team team, String imagePath) {
		this.team = team;
		this.imagePath = imagePath;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public boolean pieceIsOnMyTeam(Piece piece) {
		return this.team == piece.getTeam();
	}

	public boolean lastMoveWasOfMyTeam(Team lastMove) {
		return this.team == lastMove;
	} 
}
