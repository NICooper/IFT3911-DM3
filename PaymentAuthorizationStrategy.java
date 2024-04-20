public interface PaymentAuthorizationStrategy {

	/**
	 * 
	 * @param price
	 */
	boolean authorize(double price);

}