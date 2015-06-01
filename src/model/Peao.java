package model;

import java.awt.Point;
import java.util.ArrayList;

public class Peao extends Piece {

	private ArrayList<Point> moves;

	public Peao(Team team, String imagePath) {
		super(team,imagePath);
		this.moves = new ArrayList<Point>();
	}

	@Override
	public ArrayList<Point> getMoves(int x, int y) {
		this.moves.clear();

		if (getTeam() == Team.UP_TEAM) {
			if(x == 1) {
				this.moves.add(new Point(x+1,y));
				this.moves.add(new Point(x+2,y));
			}
			else if(x < 7)
				this.moves.add(new Point(x+1,y));
		} 
		else {
			if(x == 6) {
				this.moves.add(new Point(x-1,y));
				this.moves.add(new Point(x-2,y));
			}
			else if(x > 0)
				this.moves.add(new Point(x-1,y));
		}
		
		return this.moves;
	}
}
