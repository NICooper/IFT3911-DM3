public class CreditAuthorizeStrategy implements PaymentAuthorizationStrategy {

	/**
	 * 
	 * @param price
	 */
	public boolean authorize(double price) {
		System.out.println("Processing credit card authorization...");
		System.out.println("Amount: $" + price);
		System.out.println("Credit card authorization successful.");
		return true;
	}

}