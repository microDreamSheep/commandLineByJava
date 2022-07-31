package live.midreamsheep.command.group.download.exe;

import live.midreamsheep.command.group.Command;
import live.midreamsheep.tools.download.DownloaderStarter;

public class DownloadExeAdapter implements Command {
    @Override
    public void run(String... args) {
        new DownloaderStarter().run(args[0],args[1],args[2]);
    }
}
