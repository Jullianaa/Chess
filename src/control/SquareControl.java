package control;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import model.Piece;
import model.Piece.Team;
import model.Square;
import model.Square.SquareEventListener;

public class SquareControl implements SquareEventListener {

	public static final int ROW_NUMBER = 8;
	public static final int COL_NUMBER = 8;

	public static final Color DEFAULT_COLOR_ONE = Color.WHITE;
	public static final Color DEFAULT_COLOR_TWO = Color.GRAY;
	public static final Color DEFAULT_COLOR_HOVER = Color.BLUE;
	public static final Color DEFAULT_COLOR_SELECTED = Color.GREEN;
	public static final Color DEFAULT_COLOR_MOVE = new Color(0xFF0000);
	
	public static final Square EMPTY_SQUARE = null;

	private Color colorOne;
	private Color colorTwo;
	private Color colorHover;
	private Color colorSelected;
	private Color colorMove;
	
	private Piece.Team lastMove;
	
	private Square selectedSquare;
	private ArrayList<Square> squareList;
	//private ArrayList<Square> possibleSquares;
	
	public SquareControl() {
		this(DEFAULT_COLOR_ONE, DEFAULT_COLOR_TWO, DEFAULT_COLOR_HOVER,
				DEFAULT_COLOR_SELECTED, DEFAULT_COLOR_MOVE);
	}

	public SquareControl(Color colorOne, Color colorTwo, Color colorHover,
			Color colorSelected, Color colorMove) {
		this.colorOne = colorOne;
		this.colorTwo = colorTwo;
		this.colorHover = colorHover;
		this.colorSelected = colorSelected;
		this.colorMove = colorMove;
		this.lastMove = Team.UP_TEAM;
		this.squareList = new ArrayList<>();
	
		//this.possibleSquares = new ArrayList<>();
		
		createSquares();
	}

	public void resetColor(Square square) {
		int index = this.squareList.indexOf(square);
		int row = index / COL_NUMBER;
		int col = index % COL_NUMBER;

		square.setColor(getGridColor(row, col));
	}

	@Override
	public void onHoverEvent(Square square) {
		System.out.println("X = " + square.getPosition().x + "Y = " + square.getPosition().y);
		square.setColor(this.colorHover);
	}

	@Override
	public void onSelectEvent(Square square) {
		if (haveSelectedCellPanel()) {
			if (!this.selectedSquare.equals(square)) {
				if (this.selectedSquare.getPiece().getMoves(this.selectedSquare.getPosition().x,this.selectedSquare.getPosition().y).contains(square.getPosition())) 
				{
					moveContentOfSelectedSquare(square);
					if (lastMove.equals(Team.UP_TEAM))
						lastMove = Team.DOWN_TEAM;
					else
						lastMove = Team.UP_TEAM;
				}

			
//				if (this.selectedSquare.getPiece().getMoves(this.selectedSquare.getPosition().x,this.selectedSquare.getPosition().y).contains(square.getPosition())) 
				//{
				//
				//}
				//validar espaços vazios 
				//seleciono um qudrado -> verifico se tem peça do msm time nas posicoes posteriores e anterores a ele
				//de vermelho; se tiver não pode mover naquela direção
				//dps do quadrado q eu selecionei
			} else {
				unselectSquare(square);
			}
		} else {
			selectSquare(square);
		}
	}

	@Override
	public void onOutEvent(Square square) {
		if (this.selectedSquare == EMPTY_SQUARE)
			resetColor(square);
		else if (this.selectedSquare == square)
			square.setColor(this.colorSelected);
		else if (this.selectedSquare.getPiece().getMoves(this.selectedSquare.getPosition().x,this.selectedSquare.getPosition().y).contains(square.getPosition()))
			square.setColor(this.colorMove);
		else 
			resetColor(square);
	}

	public Square getSquare(int row, int col) {
		return this.squareList.get((row * COL_NUMBER) + col);
	}

	public ArrayList<Square> getSquareList() {
		return this.squareList;
	}

	public Color getGridColor(int row, int col) {
		if ((row + col) % 2 == 0) {
			return this.colorOne;
		} else {
			return this.colorTwo;
		}
	}

	private void addSquare() {
		Square square = new Square();
		this.squareList.add(square);
		resetColor(square);
		resetPosition(square);
		square.setSquareEventListener(this);
	}

	private void resetPosition(Square square) {
		int index = this.squareList.indexOf(square);
		int row = index / COL_NUMBER;
		int col = index % COL_NUMBER;

		square.getPosition().setLocation(row, col);
	}

	private boolean haveSelectedCellPanel() {
		return this.selectedSquare != EMPTY_SQUARE;
	}

	private void moveContentOfSelectedSquare(Square square) {
		square.setPiece(this.selectedSquare.getPiece());
		this.selectedSquare.removeImage();
		unselectSquare(square);
	}

	private void selectSquare(Square square) {
		if (square.havePiece() && !square.getPiece().lastMoveWasOfMyTeam(this.lastMove)) {
			this.selectedSquare = square;
			this.selectedSquare.setColor(this.colorSelected);
			//this.showPossibleMoves(this.selectedSquare);
			//Mudar cor de todos as posições que estão no array 'getMoves' do objeto this.square.getPiece()
			for(Point ponto: this.selectedSquare.getPiece().getMoves(this.selectedSquare.getPosition().x , this.selectedSquare.getPosition().y ) ){
				getSquare(ponto.x, ponto.y).setColor(this.colorMove);
			}
		}
	}

	private void unselectSquare(Square square) {
			

		for(Square each_square : squareList)
			resetColor(each_square);
		
		this.selectedSquare = EMPTY_SQUARE;
	}

	private void createSquares() {
		for (int i = 0; i < (ROW_NUMBER * COL_NUMBER); i++) {
			addSquare();
		}
	}


	
}