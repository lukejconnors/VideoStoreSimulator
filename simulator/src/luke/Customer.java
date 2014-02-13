package luke;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
	private String name;				// this is the name of the customer
	private List<Rental> allRentals;	// these are all the rentals the customer has
	
	public Customer(String name) {
		this.name = name;
		List<Rental> allRentals = new ArrayList<Rental>();
		this.allRentals = allRentals;
	}
	
	public String getName() {
		return name;
	}
	
	// this function will return true if the customer is able to make more rentals
	// (if the customer has three or less videos checked out) other wise false is returned
	public Boolean ableToRent(Store s) {
		if ((this.totalVids() < 3) && (s.numAvilVids() > 0)) {
			return true;
		}
		else return false;
	}
	
	// this function will check all the rentals the customer currently has to see if they
	// are due. if they are due, the customer return the video
	public void checkDue(Integer date) {
		// first a list of the rentals that are due is obtained
		List<Rental> toReturn = new ArrayList<Rental>();
		for (Rental r : allRentals) {
			if (r.isDue(date)) {
				toReturn.add(r);
			}
		}
		// next each rental that is due is returned to the store and the rental is removed 
		// from the customer's personal list of rentals
		for (Rental r : toReturn) {
			Store s = r.getStore();
			s.returnRental(r);
			allRentals.remove(r);
		}
	}
	
	// when a rental is made, the rental is added to the customer's personal list of rentals
	public void addRental(Rental r, Store s) {
		allRentals.add(r);
		s.rent(r);
	}
	
	// this function will return the total number of videos a customer currently has across 
	// all of their rentals
	public Integer totalVids() {
		Integer totalVids = 0;
		for(Rental r : allRentals) {
			totalVids += r.getVidSize();
		}
		return totalVids;
	}
	
	public abstract void rent(Store s, Integer currDate);
	
	public void printRentals() {
		System.out.println("My name is:");
		System.out.println(name);
		System.out.println("My rentals are:");
		for (Rental r : allRentals) {
			r.print();
		}
		System.out.println();
	}
}
