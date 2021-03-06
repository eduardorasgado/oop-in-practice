package behavioral.Command.TextEditorExample;

public class UndoCommand extends DocCommand {

	public UndoCommand(Application application, Editor editor) {
		super(application, editor, "UNDO");
	}

	@Override
	public boolean execute() {
		Command command = getApplication().getHistory().pop();
		command.undo();
		return false;
	}

}
