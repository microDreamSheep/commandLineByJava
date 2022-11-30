package live.midreamsheep.command.group.normal.file;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;
import live.midreamsheep.command.unimportant.Warning;

import java.io.File;
import java.util.Objects;

public class DEL implements Controller {
    @Override
    public void control(String... args) {
        for(int i = 1;i<args.length;i++){
            //判断是否是绝对路径
            File file = new File(args[i]);
            if(file.exists()){
                delete(file);
                continue;
            }
            file = new File(GlobalVariable.currentFile,args[i]);
            if(file.exists()){
                delete(file);
                continue;
            }
            System.out.println("文件删除失败");;
        }
    }
    private void delete(File file) {
        if (file.isFile()) {
            Warning.warningReturn = file.delete();
            System.out.println(file.toPath().normalize() + "已经被删除");
            return;
        }
        //删除目录下的所有文件
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            delete(listFile);
        }
        file.delete();
    }
}
