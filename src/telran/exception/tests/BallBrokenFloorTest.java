package telran.exception.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;
import telran.exceptions.NumberGreaterRangeMaxException;
import telran.exceptions.NumberLessRangeMinException;
import telran.exceptions.RangeExceptions;

class BallBrokenFloorTest {
	
	private static final int N_FLOORS = 150;
	
	@Test
	void rangeFloors() throws NumberGreaterRangeMaxException,
	NumberLessRangeMinException 
	{
		RangeExceptions range = RangeExceptions.getRangeExceptions(1, 163);
		range.checkNumber(N_FLOORS);
		assertThrowsExactly(NumberGreaterRangeMaxException.class,
				() -> range.checkNumber(164));
		assertThrowsExactly(NumberLessRangeMinException.class,
					() -> range.checkNumber(0));
         }
	
	
	@Test
	void testBallBrokenFloor() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
		
	}
	
	private int getMinBrokenFloor(BallBrokenFloor bbf) {
		int minBroken=bbf.findBrokenFloor();
		String res = String.format("Ball is broken on floor %d ", minBroken);
		System.out.printf(res);
		return  minBroken;
	}
	
}

