package luke;

public abstract class Catagory {
	private Double pricePerDay;
	private Integer maxRentLength;
	
	public Double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public Integer getMaxRentLength() {
		return maxRentLength;
	}
	public void setMaxRentLength(Integer maxRentLength) {
		this.maxRentLength = maxRentLength;
	}
}
