package live.midreamsheep.command.group.normal.file;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;

public class PWD implements Controller {
    @Override
    public void control(String... args) {
        System.out.println(GlobalVariable.currentFile.toPath().normalize());
    }
}
