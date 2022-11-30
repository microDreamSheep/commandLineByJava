package live.midreamsheep.command.group.normal.file;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;

import java.io.File;

public class MKDIR implements Controller {
    @Override
    public void control(String... args) {
        for (int i = 1; i < args.length; i++) {
            File file = new File(GlobalVariable.currentFile, args[i]);
            if(file.exists()){
                System.out.println("文件夹已经存在");
                continue;
            }
            if (file.mkdir()) {
                System.out.println("文件夹创建成功");
            } else {
                System.out.println("文件夹创建失败");
            }
        }
    }
}
