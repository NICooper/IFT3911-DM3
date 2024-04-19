import java.util.*;

public abstract class Section {

	Collection<Seat> seats;
	private Float pricePercentage;

	public Float getPricePercentage() {
		return this.pricePercentage;
	}

}