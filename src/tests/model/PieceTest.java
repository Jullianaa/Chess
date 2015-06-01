package tests.model;

import java.awt.Point;
import java.util.ArrayList;

import model.Peao;
import model.Piece;
import model.Piece.Team;
import model.Torre;


import org.junit.Assert;
import org.junit.Test;

import tests.helper.MovesTestHelper;

public class PieceTest {

	private static final Class<?> CLASSE_PEAO = Peao.class;
	private static final Class<?> CLASSE_TORRE = Torre.class;
	private static final Class<?> CLASSE_CAVALO = Piece.class;
	private static final Class<?> CLASSE_BISPO = Piece.class;
	private static final Class<?> CLASSE_REI = Piece.class;
	private static final Class<?> CLASSE_RAINHA = Piece.class;

	@Test
	public void testMovePawn() throws Exception {
		int x = MovesTestHelper.POSITION_X;
		int y = MovesTestHelper.POSITION_Y;

		Piece pieceUpTeam = newPieceInstance(CLASSE_PEAO, Team.UP_TEAM);
		Piece pieceDownTeam = newPieceInstance(CLASSE_PEAO, Team.DOWN_TEAM);

		assertMoves(MovesTestHelper.getPawnMoves(Team.UP_TEAM),
				pieceUpTeam.getMoves(x, y));
		assertMoves(MovesTestHelper.getPawnMoves(Team.DOWN_TEAM),
				pieceDownTeam.getMoves(x, y));
	}

	@Test
	public void testMoveTower() throws Exception {
		int x = MovesTestHelper.POSITION_X;
		int y = MovesTestHelper.POSITION_Y;

		Piece piece = newPieceInstance(CLASSE_TORRE, Team.UP_TEAM);

		assertMoves(MovesTestHelper.getTowerMoves(), piece.getMoves(x, y));
	}

	@Test
	public void testMoveHorse() throws Exception {
		int x = MovesTestHelper.POSITION_X;
		int y = MovesTestHelper.POSITION_Y;

		Piece piece = newPieceInstance(CLASSE_CAVALO, Team.UP_TEAM);

		assertMoves(MovesTestHelper.getHorseMoves(), piece.getMoves(x, y));
	}

	@Test
	public void testMoveBishop() throws Exception {
		int x = MovesTestHelper.POSITION_X;
		int y = MovesTestHelper.POSITION_Y;

		Piece piece = newPieceInstance(CLASSE_BISPO, Team.UP_TEAM);

		assertMoves(MovesTestHelper.getBishopMoves(), piece.getMoves(x, y));
	}

	@Test
	public void testMoveKing() throws Exception {
		int x = MovesTestHelper.POSITION_X;
		int y = MovesTestHelper.POSITION_Y;

		Piece piece = newPieceInstance(CLASSE_REI, Team.UP_TEAM);

		assertMoves(MovesTestHelper.getKingMoves(), piece.getMoves(x, y));
	}

	@Test
	public void testMoveQueen() throws Exception {
		int x = MovesTestHelper.POSITION_X;
		int y = MovesTestHelper.POSITION_Y;

		Piece piece = newPieceInstance(CLASSE_RAINHA, Team.UP_TEAM);
		ArrayList<Point> moves = new ArrayList<Point>();

		moves.addAll(MovesTestHelper.getTowerMoves());
		moves.addAll(MovesTestHelper.getBishopMoves());

		assertMoves(moves, piece.getMoves(x, y));
	}

	private Piece newPieceInstance(Class<?> classPiece, Team team)
			throws Exception {
		return (Piece) classPiece.getDeclaredConstructor(Team.class)
				.newInstance(team);
	}

	private void assertMoves(ArrayList<Point> movesA, ArrayList<Point> movesB)
			throws Exception {
		if (movesA.size() != movesB.size()) {
			Assert.assertTrue(false);
			return;
		}

		for (Point point : movesA) {
			if (!movesB.contains(point)) {
				Assert.assertTrue(false);
				return;
			}
		}

		Assert.assertTrue(true);
	}
}
