package luke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulator {

	public static void main(String[] args) {
		
		// initiate all categories 
		Catagory nR = new NewRelease();
		Catagory d = new Drama();
		Catagory r = new Romance();
		Catagory h = new Horror();
		Catagory c = new Comedy();
		
		// create all videos to be put in video store
		List<Video> availVids = new ArrayList<Video>();
		availVids.add(new Video("Lockout", nR));
		availVids.add(new Video("A Thosand Words", nR));
		availVids.add(new Video("Wanderlust", nR));
		availVids.add(new Video("Jeff, Who Lives at Home", nR));
		availVids.add(new Video("The Temptest", d));
		availVids.add(new Video("Goodbuy First Love", d));
		availVids.add(new Video("The Encounter", d));
		availVids.add(new Video("The Victim", d));
		availVids.add(new Video("Titanic", r));
		availVids.add(new Video("Tonight You Are Mine", r));
		availVids.add(new Video("Big Mericale", r));
		availVids.add(new Video("Four Lovers", r));
		availVids.add(new Video("Bait", h));
		availVids.add(new Video("The Revrant", h));
		availVids.add(new Video("Dead Soon", h));
		availVids.add(new Video("Entrance", h));
		availVids.add(new Video("Damsel In Distress", c));
		availVids.add(new Video("Baby Makers", c));
		availVids.add(new Video("Game of Life", c));
		availVids.add(new Video("High School", c));
		Collections.shuffle(availVids);
		
		// add all videos to store
		Store s = new Store(availVids);
		
		// create all customers and add to a list
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Hoarder("Bob"));
		customers.add(new Hoarder("Jane"));
		customers.add(new Hoarder("Steve"));
		customers.add(new Breezy("Kara"));
		customers.add(new Breezy("Joey"));
		customers.add(new Breezy("Haley"));
		customers.add(new Regular("Greg"));
		customers.add(new Regular("Shasa"));
		customers.add(new Regular("Tommy"));
		customers.add(new Regular("Vanessa"));
		
		// create integer to hold date and end date
		Integer currDate;
		Integer endDate = 35;
		
		// loop through each day to perform necessary actions
		for(currDate = 1; currDate <= endDate; currDate++) {
			// first have each customer check if any of there rentals are due, if so return them
			for (Customer c1 : customers) {
				c1.checkDue(currDate);
			}
			// make a list of the customers that are able to rent by iterating through all customers
			// and checking if they are able to rent
			List<Customer> ableToRent = new ArrayList<Customer>();
			if(s.numAvilVids() > 0) {	
				for (Customer c1 : customers) {
					if(c1.ableToRent(s)) {
						ableToRent.add(c1);
					}
				}
			// get the number of customers able to rent and make a random number 
			// between 1 and numAvailToRent
			Integer numAvailToRent = ableToRent.size();
			Integer numRenters =  1 + (int)(Math.random() * ((numAvailToRent - 1) + 1));
			// shuffle the array of customers able to rent to get random customers
			Collections.shuffle(ableToRent);
			// select the random renters and tell them to make a rental from the store
			for(int i = 0; i < numRenters; i++) {
				Customer c1 = ableToRent.get(i);
				if(c1.ableToRent(s)) {
					c1.rent(s, currDate);
				}
			}
			}
		}
		
		// print necessary information about the simulation
		s.printAvailVids();
		s.printUnavailVids();
		System.out.println("The amount of money made by video store in " + currDate + " days:");
		System.out.println(s.getMoney());
	}
}
