package luke;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public List<Video> availVids;		// the list of videos available for rental
	public List<Video> unavailVids;		// the list of videos that are checked out currently
	public Double money;				// the amount of money the store has made
	
	public Store() {
		this.availVids = new ArrayList<Video>();
		this.unavailVids = new ArrayList<Video>();
		this.money = 0.0;
	}
	
	public Store(List<Video> availVids) {
		this.availVids = availVids;
		this.unavailVids = new ArrayList<Video>();
		this.money = 0.0;
	}
	
	public List<Video> getAvailVids() {
		return availVids;
	}
	
	public void addNewVid(Video v) {
		availVids.add(v);
	}
	
	public Integer numAvilVids() {
		return availVids.size();
	}
	
	public List<Video> getUnavailVids() {
		return unavailVids;
	}
	
	public Double getMoney() {
		return money;
	}
	
	// this function will process a rental made by a customer by removing the videos
	// being rented from the available list of videos and putting them on the check out
	// list of videos, lastly it will process the money transaction
	public void rent(Rental r) {
		List<Video> videos = r.getVideos();
		for (Video v : videos) {
			// if the video attempting to be rented is not available to rent, then throw
			// and error and exit the program
			if(!availVids.contains(v)) {
				System.out.println("ERROR: Store does not have video tring to be rented.");
				System.exit(1);
			}
			else {
				availVids.remove(v);
				unavailVids.add(v);
			}
		}
		money += r.getCost();
	}
	
	// this function will process a return of a rental made by a customer by removing all
	// videos on the rental from being checked out to available
	public void returnRental(Rental r) {
		List<Video> videos = r.getVideos();
		for (Video v : videos) {
			// if the customer is attempting to return a video that is not checked out,
			// then throw an error and exit the program
			if(availVids.contains(v)) {
				System.out.println("ERROR: Attempting to return a video already in store.");
			    System.exit(1);
			}
			else {
				availVids.add(v);
				unavailVids.remove(v);
			}	
		}
	}
	
	public void printAvailVids() {
		System.out.println("Store's " + availVids.size() + "avialible videos:");
		for(Video v : availVids) {
			v.print();
		}
		System.out.println();
	}
	
	public void printUnavailVids() {
		System.out.println("Store's " + unavailVids.size() + "unavialible videos:");
		for(Video v : unavailVids) {
			v.print();
		}
		System.out.println();

	}
}
