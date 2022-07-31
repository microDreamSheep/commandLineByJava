package live.midreamsheep.command;

import live.midreamsheep.command.control.CoreController;
import live.midreamsheep.tools.download.DownloaderStarter;

public class ApplicationStarter {
    public static void main(String[] args) {
        new CoreController().Start();
    }
}
