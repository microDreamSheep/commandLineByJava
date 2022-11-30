package live.midreamsheep.command.group.normal.file;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;

public class MK implements Controller {
    @Override
    public void control(String... args) {
        for (int i = 1; i < args.length; i++) {
            File file = new File(GlobalVariable.currentFile, args[i]);
            if(file.exists()){
                System.out.println("文件已经存在");
                continue;
            }
            try (OutputStream os = Files.newOutputStream(file.toPath())) {
            }catch (Exception e){
                System.out.println("文件创建失败");
                return;
            }
            System.out.println("文件创建成功");
        }
    }
}
