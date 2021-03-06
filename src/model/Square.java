package model;

import java.awt.Color;
import java.awt.Point;

public class Square {

	public interface SquareEventListener {
		public void onOutEvent(Square square);

		public void onHoverEvent(Square square);

		public void onSelectEvent(Square square);
	}

	public interface SquareChangeListener {
		public void onColorChange(Square square);

		public void onChangeImagePath(Square square);	
	}

	public static final int DEFAULT_SIZE = 64;
	//public static final String EMPTY_PATH = "";
	public static final Piece EMPTY_SQUARE = null;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	public static final SquareEventListener EMPTY_EVENT_LISTENER = null;
	public static final SquareChangeListener EMPTY_CHANGE_LISTENER = null;

	private Color color;
	private Integer size;
	private Point position;
	private Piece piece;
	//private String imagePath;

	private SquareEventListener squareEventListener;
	private SquareChangeListener squareChangeListener;

	public Square() {
		this(0, 0);
	}

	public Square(int x, int y) {
		this(new Point(x, y));
	}

	public Square(Point position) {
		this(position, DEFAULT_COLOR);
	}

	public Square(int x, int y, Color color) {
		this(x, y, color, EMPTY_SQUARE);
	}

	public Square(Point position, Color color) {
		this(position, color, EMPTY_SQUARE);
	}

	public Square(int x, int y, Color color, int size) {
		this(x, y, color, EMPTY_SQUARE, size);
	}

	public Square(Point position, Color color, int size) {
		this(position, color, EMPTY_SQUARE, size);
	}

	public Square(int x, int y, Color color, Piece piece) {
		this(new Point(x, y), color, piece, DEFAULT_SIZE);
	}

	public Square(Point position, Color color, Piece piece) {
		this(position, color, piece, DEFAULT_SIZE);
	}

	public Square(int x, int y, Color color, Piece piece, int size) {
		this(new Point(x, y), color, piece, size);
	}

	public Square(Point position, Color color, Piece piece, int size) {
		this.size = size;
		this.color = color;
		this.position = position;
		this.piece = piece;

		this.squareEventListener = EMPTY_EVENT_LISTENER;
	}

	public void removeImage() {
		this.piece = EMPTY_SQUARE;
		notifyOnChangeImagePath();
	}

	public void notifyOnOutEvent() {
		if (haveSquereEventListener()) {
			this.squareEventListener.onOutEvent(this);
		}
	}

	public void notifyOnHoverEvent() {
		if (haveSquereEventListener()) {
			this.squareEventListener.onHoverEvent(this);
		}
	}

	public void notifyOnSelectEvent() {
		if (haveSquereEventListener()) {
			this.squareEventListener.onSelectEvent(this);
		}
	}

	public void notifyOnColorChange() {
		if (haveSquareChangeListener()) {
			this.squareChangeListener.onColorChange(this);
		}
	}

	public void notifyOnChangeImagePath() {
		if (haveSquareChangeListener()) {
			this.squareChangeListener.onChangeImagePath(this);
		}
	}

	public Point getPosition() {
		return this.position;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	/*public boolean haveImagePath() {
		return this.imagePath != EMPTY_PATH;
	}*/
	
	public boolean havePiece() {
		return this.piece != EMPTY_SQUARE;
	}
	
	/*public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		notifyOnChangeImagePath();
	}*/

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		notifyOnColorChange();
	}

	public void setSquareEventListener(SquareEventListener squareEventListener) {
		this.squareEventListener = squareEventListener;
	}

	public void setSquareChangeListener(
			SquareChangeListener squareChangeListener) {
		this.squareChangeListener = squareChangeListener;
	}

	private boolean haveSquereEventListener() {
		return this.squareEventListener != EMPTY_EVENT_LISTENER;
	}

	private boolean haveSquareChangeListener() {
		return this.squareChangeListener != EMPTY_CHANGE_LISTENER;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
		notifyOnChangeImagePath();
	}
}
