package live.midreamsheep.command.group.download;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;
import live.midreamsheep.command.group.download.exe.DownloadExeAdapter;

public class DownloadController implements Controller {
    @Override
    public void control(String... args) {
        if(args.length<3){
            System.out.println("参数错误");
            return;
        }
        switch (args[1]){
            case "exe":
                new DownloadExeAdapter().run(args[2],args.length>=4?args[3]:"1", GlobalVariable.currentFile.getAbsolutePath());
                break;
            default:
                System.out.println("没有该下载命令");
                break;
        }
    }
}
