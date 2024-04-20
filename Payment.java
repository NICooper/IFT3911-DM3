public class Payment{

	private PaymentAuthorizationStrategy strategy;
	private double amount;
	private String id;

	public Payment(PaymentAuthorizationStrategy strategy) {
		this.strategy = strategy;
		this.amount = amount;
		this.id = id;
	}

	public boolean processPayment(double amount) {
		return strategy.authorize(this.amount);
	}
}

