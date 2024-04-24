import java.util.ArrayList;
import java.util.Stack;

public class Administrator implements Observer<ApplicationGetters> {

	private final Stack<Command> commandHistory = new Stack<>();

	private Command command;

	private AdminView adminView;
	//private State state;

	public boolean undo() {
		if (!commandHistory.empty()) {
			var topCommand = commandHistory.pop();
			return topCommand.undo();
		}
		return false;
	}

	public boolean runCommand(Command command) {
		if (command.execute()) {
			commandHistory.push(command);
			return true;
		}
		return false;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void exec() {
		if (command.execute()) {
			commandHistory.push(command);
		}
	}

	@Override
	public void update(ApplicationGetters object) {
		return;
	}
}