package testing;
import othello.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class TestBlackWins {

	private static OthelloWidget igra1;
	private static JSpotBoard mapa;
	
	
	//@Bef
	
	@BeforeAll
	public static void pocetnoStanje() {
		igra1=new OthelloWidget();
		mapa=igra1.getBoard();
	}
	
	@ParameterizedTest
	@CsvFileSource(files="src/test/resources/BookTest2.csv",numLinesToSkip=1)
	public void testParamCrniPobedjujeU9Poteza(String x,String y) {

		int xx=Integer.valueOf(x);
		int yy=Integer.valueOf(y);
		//System.out.println(x+" "+y);
		Spot polje=mapa.getSpotAt(xx, yy);
		igra1.spotClicked(polje);

		if(igra1.checkWin()) {
			//assertTrue(igra1.getWinner()=="Black");
			assertTrue( igra1._noBlack>igra1._noWhite);
			
			assertFalse(igra1.hasLegalMoves(0, polje));
		}
		else {
			assertTrue(igra1.hasLegalMoves());
		}
	}
	

}
