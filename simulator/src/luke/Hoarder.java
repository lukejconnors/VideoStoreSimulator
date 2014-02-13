package luke;

import java.util.ArrayList;
import java.util.List;

public class Hoarder extends Customer {
	
	public Hoarder(String name) {
		super(name);
	}
	
	// this is the function to describe the method that hoarder customers rent. a hoarder customer
	// will make a rental always of 3 videos and always for the maximum length of time (7 days).
	public void rent(Store s, Integer currDate) {
		// check to make sure that the customer does not already have rentals totaling to more that 
		// 3 videos, if they do throw an error and exit
		if (super.totalVids() >= 3) {
			System.out.println("ERROR: Customer " + super.getName() + " has 3 or more videos and should not be renting.");
		    System.exit(1);
		}
		
		List<Video> availVids = s.getAvailVids();
		// check to make sure that the store has at least 3 videos in it. if the store does not,
		// the hoarder customer should not be renting, throw an error and exit
		if (availVids.size() < 3) {
			System.out.println("ERROR: Customer " + super.getName() + " is a horder, there are not enough videos in store to rent.");
		    System.exit(1);
		}
		
		Integer maxRentLength = 0;
		// a hoarder customer will always rent 3 videos
		Integer rentNum = 3;
		List<Video> vids = new ArrayList<Video>();
		// get a list of 3 videos to rent from the available videos at the store
		for(int i = 0; i < rentNum; i++) {
			Video v = availVids.get(i);
			vids.add(v);
			// a hoarder will always rent for the maximum rental length
			maxRentLength = v.getMaxRentLength();
		}
		
		// create the rental and add it to the customer's list of rentals
		Rental r = new Rental(this, vids, s, maxRentLength, currDate);
		super.addRental(r, s);
	}
	
	// for a hoarder customer, they can only rent if they have less than three videos
	// and the video store has at least three videos. this function will return true
	// in the case a hoarder customer can rent and false otherwise
	public Boolean ableToRent(Store s) {
		if ((super.totalVids() < 3) && (s.getAvailVids().size() > 2)) {
			return true;
		}
		else return false;
	}
}
