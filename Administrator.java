import java.util.ArrayList;
import java.util.Stack;

public class Administrator implements Observer{

	private String name;
	private String id;
	private final Stack<Command> commandHistory = new Stack<>();
	private ArrayList<Object>[] news;

	public ArrayList<Object>[] getNews() {
		return news;
	}

	public void setNews(ArrayList<Object>[] news) {
		this.news = news;
	}

	private Command command;

	private AdminView adminView;
	//private State state;

	public void undo() {
		var topCommand = commandHistory.pop();
		topCommand.undo();
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void exec(){
		command.execute();
	}

	@Override
	public void update(ArrayList<Object>[] news) {
		this.setNews(news);
	}
}