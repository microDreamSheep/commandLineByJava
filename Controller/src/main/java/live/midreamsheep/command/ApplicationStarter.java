package live.midreamsheep.command;

import live.midreamsheep.command.control.CoreController;

public class ApplicationStarter {
    public static void main(String[] args) {
        new CoreController().Start();
    }
}
