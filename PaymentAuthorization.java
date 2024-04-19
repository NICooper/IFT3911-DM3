public interface PaymentAuthorization {

	/**
	 * 
	 * @param price
	 */
	boolean authorize(float price);

}