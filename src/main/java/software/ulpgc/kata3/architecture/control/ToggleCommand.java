package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.io.BarchartLoader;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

public class ToggleCommand implements Command {
    private final BarchartDisplay display;
    private final BarchartLoader loader;

    public ToggleCommand(BarchartDisplay display, BarchartLoader loader) {
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() {
        display.show(loader.load());
    }
}
