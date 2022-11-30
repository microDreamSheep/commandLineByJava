package live.midreamsheep.command.control;

import live.midreamsheep.command.group.Controller;
import live.midreamsheep.command.group.normal.file.CD;
import live.midreamsheep.command.group.normal.file.DEL;
import live.midreamsheep.command.group.normal.file.LS;
import live.midreamsheep.command.group.normal.file.PWD;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandManager {
    private static final Map<String, Controller> controllerMap = new HashMap<>();
    static{
        //标准命令存入
        {
            //cd切换路径
            controllerMap.put("cd", new CD());
            //pwd列出当前路径
            controllerMap.put("pwd", new PWD());
            //ls
            controllerMap.put("ls", new LS());
            //del命令
            controllerMap.put("del",new DEL());
        }
    }
    public static Controller getController(String name){
        return Optional.ofNullable(controllerMap.get(name)).orElse(args -> {
            System.err.println("命令不存在");
        });
    }
    public static void addController(String name,Controller controller){
        controllerMap.put(name,controller);
    }
}
