package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import othello.JSpotBoard;
import othello.OthelloWidget;
import othello.Spot;

class TestDraw {

	private static OthelloWidget igra1;
	private static JSpotBoard mapa;

	
	@BeforeAll
	public static void pocetnoStanje() {
		igra1=new OthelloWidget();
		mapa=igra1.getBoard();
	}
	
	@ParameterizedTest
	@CsvFileSource(files="src/test/resources/BookTestDraw.csv", numLinesToSkip = 1,delimiter = ';')
	public void TestParamDrawGameWithOneIllegalMove(int x, int y) {

		Spot polje=mapa.getSpotAt(x, y);
		
		if(!igra1.isLegalMove(polje) ) {
			assertFalse(igra1.isLegalMove(polje));
		}
		else {
			igra1.spotClicked(polje);
			if(!igra1.checkWin()) {
				assertTrue(igra1.hasLegalMoves());
			}
			else {
				assertTrue(igra1.checkDraw());
			}
		}

	}

}
