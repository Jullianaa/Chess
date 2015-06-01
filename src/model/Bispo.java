package model;

import java.awt.Point;
import java.util.ArrayList;

import model.Piece;

public class Bispo extends Piece {
	private ArrayList<Point> moves;

	public Bispo(Team team, String imagePath) {
		super(team, imagePath);
		this.moves = new ArrayList<Point>();
}
	
	public ArrayList<Point> getMoves(int x, int y) {
		this.moves.clear();

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
		
		return this.moves;
	}	
}
