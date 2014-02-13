package luke;

public class Video {
	private String title;			// title of the video
	private Catagory catagory;		// the category or genre of the video
	private Double pricePerDay;		// the cost of the video per night to rent
	private Integer maxRentLength;	// the maxim number of days a video can be rented for
	
	public Video(String title, Catagory catagory) {
		this.title = title;
		this.setCatagory(catagory);
		this.pricePerDay = catagory.getPricePerDay();
		this.maxRentLength = catagory.getMaxRentLength();
	}
	
	public Double getPricePerDay() {
		return pricePerDay;
	}
	
	public Integer getMaxRentLength() {
		return maxRentLength;
	}
	
	// in case the category or genre of the video changes
	public void changeCatagory(Catagory newCatagory) {
		this.setCatagory(newCatagory);
		this.pricePerDay = newCatagory.getPricePerDay();
	}
	
	public void print() {
		System.out.println(title);
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}
}
