package live.midreamsheep.command.group.normal.file;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;

import java.io.File;

public class CD implements Controller {
    @Override
    public void control(String... args) {
        if(args.length<2){
            System.out.println("参数错误");
            return;
        }
        File file = new File(GlobalVariable.currentFile,args[1]);
        if(file.exists()&&file.isDirectory()){
            System.out.println(file.toPath().normalize());
            //相对
            GlobalVariable.currentFile = file;
            return;
        }
        file = new File(args[1]+"//");
        if(file.exists()&&file.isDirectory()){
            System.out.println(file.getAbsolutePath());
            GlobalVariable.currentFile = file;
            return;
        }
        System.out.println("文件找不到");
    }
}
