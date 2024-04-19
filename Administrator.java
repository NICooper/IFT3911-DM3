import java.util.ArrayList;

public class Administrator implements Observer{

	private String name;
	private String id;
	private ArrayList<Command> historiquesCommandes; //stack ?
	private ArrayList<Object>[] news;

	public ArrayList<Object>[] getNews() {
		return news;
	}

	public void setNews(ArrayList<Object>[] news) {
		this.news = news;
	}

	private AdminView adminView;
	//private State state;

	public void undo() {
		// TODO - implement Administrator.undo
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(ArrayList<Object>[] news) {
		this.setNews(news);
	}
}