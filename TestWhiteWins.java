package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import othello.JSpotBoard;
import othello.OthelloWidget;
import othello.Spot;

class TestWhiteWins {

	private static OthelloWidget igra1;
	private static JSpotBoard mapa;
	
	
	@BeforeAll
	public static void pocetnoStanje() {
		igra1=new OthelloWidget();
		mapa=igra1.getBoard();
	}
	
	@ParameterizedTest
	@CsvFileSource(files="src/test/resources/BookTestWhiteWins.csv",numLinesToSkip = 1,delimiter = ';')
	public void testParamBeliPobedjuje(String x,String y) {

		int xx=Integer.valueOf(x);
		int yy=Integer.valueOf(y);
		//System.out.println(x+" "+y+" i br="+br);
		Spot polje=mapa.getSpotAt(xx, yy);
		igra1.spotClicked(polje);
		if(igra1.checkWin()) {
			assertTrue(igra1._noWhite>igra1._noBlack);
		}
		else {
			assertTrue(igra1.hasLegalMoves());
		}
	}

}
