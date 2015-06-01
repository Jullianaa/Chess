package model;

import java.awt.Point;
import java.util.ArrayList;

import model.Piece;

public class Cavalo extends Piece {
	private ArrayList<Point> moves;

	public Cavalo(Team team, String imagePath) {
		super(team, imagePath);
		this.moves = new ArrayList<Point>();
	}

	public ArrayList<Point> getMoves(int x, int y) {
		this.moves.clear();
		
		if (x-1 >= 0 && y-2 >= 0)
			this.moves.add(new Point(x-1,y-2));
		if (x-2 >= 0 && y-1 >= 0)
			this.moves.add(new Point(x-2,y-1));	
		if (x-2 >=0 && y+1 <=7)
			this.moves.add(new Point(x-2,y+1));
		if (x-1 >=0 && y+2 <=7)
			this.moves.add(new Point(x-1,y+2));
		if (x+2 <=7 && y+1 <=7)
			this.moves.add(new Point(x+2,y+1));	
		if (x+1 <=7 && y+2 <=7)
			this.moves.add(new Point(x+1,y+2));	
		if (x+1 <=7 && y-2 >= 0)
			this.moves.add(new Point(x+1,y-2));
		if (x+2<=7 && y-1 >= 0)
			this.moves.add(new Point(x+2,y-1));	
		
		
		
		}	
				
		return this.moves;
	}
}

