package model;

import java.awt.Point;
import java.util.ArrayList;

import model.Piece.Team;

public class Rei extends Piece{
	private ArrayList<Point> moves;

	public Rei(Team team, String imagePath) {
		super(team, imagePath);
		this.moves = new ArrayList<Point>();
	}

	@Override
	public ArrayList<Point> getMoves(int x, int y) {
		this.moves.clear();

		if(( x+1 <= 7)&& (y+1 < 7)) {							
			this.moves.add(new Point(x+1, y+1));
		}
	
		if(( x-1 >= 0)&& (y-1 >0)) {							
			this.moves.add(new Point(x-1, y-1));
		}
		
		if(( x+1 <= 7)&& (y-1 > 0)) {							
			this.moves.add(new Point(x+1, y-1));
		}
		
		if(( x-1 >= 0 )&& (y+1 < 7)) {							
			this.moves.add(new Point(x-1, y+1));
		}
		
		if(( x-1 >= 0)&& (y <= 7)) {							
			this.moves.add(new Point(x-1, y));
		}
	
		if(( x >= 0)&& (y+1 < 7)) {							
			this.moves.add(new Point(x, y+1));
		}
		
		if(( x+1 <= 7)&& (y <= 7)) {							
			this.moves.add(new Point(x+1, y));
		}
		
		if(( x >= 0)&& (y-1 >0)) {							
			this.moves.add(new Point(x, y-1));
		}
	
		return this.moves;
	}
}
