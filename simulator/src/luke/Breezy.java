package luke;

import java.util.ArrayList;
import java.util.List;

public class Breezy extends Customer {
	
	public Breezy(String name) {
		super(name);
	}
	
	// this is the function to describe the method that breezy customers rent. a breezy customer
	// will make a rental of anywhere from 1 - 2 videos always for 2 days.
	public void rent(Store s, Integer currDate) {
		// check to make sure that the customer does not already have rentals totaling to more that 
		// 3 videos, if they do throw an error and exit
		if (super.totalVids() >= 3) {
			System.out.println("ERROR: Customer " + super.getName() + " has 3 or more videos and should not be renting.");
		    System.exit(1);
		}
		
		// figure out the number of videos the regular customer will rent
		Integer rentNum;
		// in the case that there is only 1 available video in the store, 
		// or the regular customer already has 2 videos, only rent 1 video 
		if(s.numAvilVids() < 2 || (super.totalVids() == 2)) {
			rentNum = 1;
		}
		// otherwise the breezy customer is able to rent anywhere between (1,2) videos
		else {
			// generate random number between (1,2)
			rentNum = 1 + (int)(Math.random() * ((2 - 1) + 1));			
		}
		
		// get the list of available videos in the store
		List<Video> availVids = s.getAvailVids();
		List<Video> vids = new ArrayList<Video>();
		// pick the number of videos to be rented from the list of available in the store
		// and make a list of those videos
		for(int i = 0; i < rentNum; i++) {
			Video v = availVids.get(i);
			vids.add(v);
		}
		
		// a breezy customer always makes a rental for a length of 2 days
		Integer rentLength = 2;
		// create the rental and add it to the customer's list of rentals
		Rental r = new Rental(this, vids, s, rentLength, currDate);
		super.addRental(r, s);
	}
}
