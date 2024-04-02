package telran.exceptions;

import java.util.Random;

public class BallBrokenFloor {
	private int brokenFloor;
	private int nFloors;
	public BallBrokenFloor(int nFloors) {
		this.nFloors = nFloors;
		brokenFloor = new Random().nextInt(1, nFloors + 1);
	}
	public int getBrokenFloor() {
		return brokenFloor;
	}
	 	
	public void checkFloor(int floor) throws Exception {
		if (floor >= brokenFloor) {
			throw new Exception ();
		}
	}

    public int findBrokenFloor() {
	    int low=1;
	    int height=nFloors;
	    while(low<=height) {
		   int middle=(low+height)/2;
		   try {
			   checkFloor(middle);
			   low=middle+1;
			   }catch(Exception e) {
		        height=middle-1;
		       }
	    }
	return low;
	}
}