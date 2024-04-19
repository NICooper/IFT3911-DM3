import Observer.*;

public class Administrator implements update, Observer {

	private String name;
	private String id;
	private ArrayList<Commande> historiquesCommandes;

	public void undo() {
		// TODO - implement Administrator.undo
		throw new UnsupportedOperationException();
	}

}