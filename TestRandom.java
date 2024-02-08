package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import othello.JSpot;
import othello.JSpotBoard;
import othello.OthelloWidget;
import othello.Spot;

class TestRandom {

	@Test
	void test() {
		
		JSpotBoard board1= new JSpotBoard(8,8,Color.BLUE,Color.RED);
		assertTrue(board1!=null);
				
		
	}
	
	@Test
	void test2() {
		try {
			JSpotBoard board2= new JSpotBoard(51,2,Color.BLUE,Color.RED);
		} catch (IllegalArgumentException e) {
			assertTrue(e.toString().contains("Illegal spot board geometry"));
		}
		
	}
	
	@Test
	void test3() {
		JSpotBoard board3= new JSpotBoard(8,8);
		assertTrue(board3!=null);
	}
	
	@Test
	void test4() {
		assertThrows(IllegalArgumentException.class, ()->{
			JSpotBoard board4= new JSpotBoard(0,2);
		});
	}
	
	@Test
	void test5() {
		assertThrows(IllegalArgumentException.class, ()->{
			JSpotBoard board5 = new JSpotBoard(0, 8, new Color(0.5f, 0.5f, 0.5f));
		});
	}
	
	@Test
	void test6() {
		OthelloWidget igra=new OthelloWidget();
		JSpotBoard teren=igra.getBoard();
		Spot polje=teren.getSpotAt(3, 3);
		polje.setHighlight(Color.YELLOW);
		polje.highlightSpot();
		System.out.println(polje.getBoard().getSpotHeight()+", "+polje.getBoard().getSpotWidth());
		assertTrue(polje.getHighlight()==Color.YELLOW && polje.isHighlighted());
		
	}
	
	@Test
	void test7() {
		OthelloWidget igra=new OthelloWidget();
		JSpotBoard teren=igra.getBoard();
		Spot polje=teren.getSpotAt(3, 5);
		assertTrue(igra.hasLegalMoves(0, polje));
	}

	@Test
	void test8() {
		OthelloWidget igra=new OthelloWidget();
		JSpotBoard teren=igra.getBoard();
		Spot polje=null;
		try {
			polje=teren.getSpotAt(0, 10);
		} catch (IllegalArgumentException e) {
			assertTrue(e.toString().contains("Illegal spot coordinates"));
		}
	}
	
	@Test
	void test9() {
		OthelloWidget igra=new OthelloWidget();
		JSpotBoard teren=igra.getBoard();
		Spot polje=teren.getSpotAt(3, 3);
		polje.toggleHighlight();
		assertTrue(polje.getCoordString().contains("(3, 3)"));
		polje.toggleSpot();
		polje.toggleHighlight();
		
	}
	
}
