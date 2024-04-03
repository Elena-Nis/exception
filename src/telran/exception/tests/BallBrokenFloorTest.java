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
		int brokenFloor = bbf.getBrokenFloor();
		int low=1;
		int height=N_FLOORS;
		    while(low<=height) {
			   int middle=(low+height)/2;
			   try {
				   bbf.checkFloor(middle);
				   low=middle+1;
				   }catch(Exception e) {
			        height=middle-1;
			       }
		    }
		assertEquals(brokenFloor, low);
		System.out.printf("Ball broke on floor %d", low);
		
	}
	
	
}

