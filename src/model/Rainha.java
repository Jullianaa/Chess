package model;

import java.awt.Point;
import java.util.ArrayList;

import model.Piece.Team;

public class Rainha extends Piece {
	private ArrayList<Point> moves;

	public Rainha(Team team, String imagePath) {
		super(team, imagePath);
		this.moves = new ArrayList<Point>();
	}
	public ArrayList<Point> getMoves(int x, int y) {
		this.moves.clear();

		for (int i = 0; i < CHESSBOARD_ROW; i++) { //horizontal
			if (i != y) 
				this.moves.add(new Point(x, i));
		}
		
		for (int i = 0; i < CHESSBOARD_COL; i++) { //vertical
			if (i != x)
				this.moves.add(new Point(i, y));
		}
		
	int x_aux, y_aux;
		
		x_aux = x - 1;
		y_aux = y - 1;
		while((x_aux >= 0) && (y_aux >= 0)) {
			this.moves.add(new Point(x_aux, y_aux));
			x_aux = x_aux - 1;
			y_aux = y_aux - 1;
		}
	
		x_aux = x + 1;
		y_aux = y + 1;
		 while ((x_aux <= 7) && (y_aux <= 7)) {
			this.moves.add(new Point(x_aux, y_aux));
			x_aux = x_aux + 1;
			y_aux = y_aux + 1;
		}
		 
		 x_aux = x + 1;
		 y_aux = y - 1;
			 while ((x_aux <=7) && (y_aux >= 0)) {
				this.moves.add(new Point(x_aux, y_aux));
				x_aux = x_aux + 1;
				y_aux = y_aux - 1;
			}
			 
		 x_aux = x - 1;
		 y_aux = y + 1;
			 while ((x_aux >=0) && (y_aux <=7)) {
				this.moves.add(new Point(x_aux, y_aux));
				x_aux = x_aux - 1;
				y_aux = y_aux + 1;
		 }
		
//		for (int j = 1; j < CHESSBOARD_ROW; j++) {
//			
//			if(j+1<=7)
//				this.moves.add(new Point(x+j, y+j));
//				
//			if(j-1>=0)
//				this.moves.add(new Point(x-j, y-j));
//				
//			if(x-j<=7 && y+j<=7)
//				this.moves.add(new Point(x-j, y+j));
//			
//			if(x+j>=0 && y-j>=0)
//				this.moves.add(new Point(x+j, y-j));
//		}	
		
		return this.moves;
	}
}

