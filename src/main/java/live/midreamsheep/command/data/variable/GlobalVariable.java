package live.midreamsheep.command.data.variable;

import java.io.File;

public class GlobalVariable {
    //命令行前缀
    public static String prefix = "CLBJ";
    //命令行分割
    public static final String SEPARATE = ">";
    //退出标识
    public static boolean IS_EXIT = false;

    //当前文件
    public static File currentFile = new File(System.getProperty("user.dir"));
}