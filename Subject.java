import java.util.ArrayList;

public interface Subject {

	/**
	 * 
	 * @param observer
	 */
	void attach(Observer observer);

	/**
	 * 
	 * @param observer
	 */
	void detach(Observer observer);

	void notifyObservers();

}