package taa.command;

import taa.storage.Storage;
import taa.exception.TaaException;
import taa.Ui;
import taa.module.ModuleList;

public class ExitCommand extends Command {
    private static final String MESSAGE_FORMAT_EXIT_USAGE = "%s";

    public ExitCommand(String argument) {
        super(argument);
    }

    /**
     * Executes the exit command and exits the program.
     *
     * @param moduleList The list of modules.
     * @param ui         The ui instance to handle interactions with the user.
     * @param storage    The storage instance to handle saving.
     * @throws TaaException If the user inputs an invalid command.
     */
    @Override
    public void execute(ModuleList moduleList, Ui ui, Storage storage) throws TaaException {
        if (!argument.isEmpty()) {
            throw new TaaException(getUsageMessage());
        }

        ui.printExitMessage();
        this.isExit = true;
    }

    @Override
    protected String getUsage() {
        return String.format(MESSAGE_FORMAT_EXIT_USAGE, COMMAND_EXIT);
    }
}