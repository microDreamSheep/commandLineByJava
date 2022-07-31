package live.midreamsheep.command.group.normal.file;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class LS implements Controller {
    @Override
    public void control(String... args) {
        //列出当前目录所有文件
        for (File file : Objects.requireNonNull(GlobalVariable.currentFile.listFiles())) {
            System.out.println("--"+file.getName());
        }
    }
}
