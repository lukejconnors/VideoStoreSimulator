package luke;

import java.util.List;

public class Rental {
	private Integer dueDate;	//the date the rental is due
	private Integer vidSize;	//the number of videos in the rental
	private List<Video> videos;	//the list of videos in rental
	private Double cost;		//the cost of the entire rental
	private Customer owner;		//the customer that is renting the videos
	private Store store;		//the store where the videos were rented
	
	public Rental(Customer owner, List<Video> videos, Store store, Integer rentLength, Integer currDate) {
		this.owner = owner;	
		this.store = store;
		this.dueDate = rentLength + currDate;
		this.videos = videos;
		Integer s = videos.size();
		// no rental can be more that 3 videos, check to make sure that the number of videos does not
		// exceed 3, if so throw and error
		if (s <= 3) {
			this.vidSize = s;
		}
		else {
			System.out.println("ERROR: Customer " + owner + " is trying to rent more than 3 videos.");
		    System.exit(1);
		}
		this.cost = this.calcCost(this.videos, rentLength); 
	}
	
	// will return true if the rental is due
	public Boolean isDue(Integer currDate) {
		if (currDate == dueDate) return true;
		else return false;
	}
	
	public Customer getOwner() {
		return owner;
	}
	
	public Integer getVidSize() {
		return vidSize;
	}
	
	public Store getStore() {
		return store;
	}
	
	public List<Video> getVideos() {
		return videos;
	}
	
	public Double getCost() {
		return cost;
	}
	
	// will calculate the cost of the rental based on the price per night of each video and
	// the length of the rental
	private Double calcCost(List<Video> videos, Integer length) {
		Double cost = 0.0;
		for(Video v : videos) {
			cost += (v.getPricePerDay() * length);
		}
		return cost;
	}
	
	void print() {
		System.out.println("Rental contains videos:");
		for(Video v : videos) {
			v.print();
		}
		System.out.println("Rental due date:");
		System.out.println(dueDate);
		System.out.println("Rental cost:");
		System.out.println(cost);
	}
}
