package live.midreamsheep.command.group.normal.command;

import live.midreamsheep.command.data.variable.GlobalVariable;
import live.midreamsheep.command.group.Controller;

import java.io.InputStream;

public class Commmand implements Controller {
    @Override
    public void control(String... args) {
        new Thread(()-> {
            try {
                StringBuilder sb = new StringBuilder();
                for (String s : args) {
                    sb.append(s).append(" ");
                }
                byte[] buffer = new byte[1024];
                int len;
                Runtime runtime = Runtime.getRuntime();
                Process process = runtime.exec("cmd /c " + GlobalVariable.currentFile.toPath().normalize() + "//" + sb);
                try (InputStream results = process.getInputStream(); InputStream error = process.getErrorStream()) {
                    while ((len = results.read(buffer)) != -1) {
                        System.out.println(new String(buffer, 0, len, "GBK"));
                    }
                    while ((len = error.read(buffer)) != -1) {
                        System.out.println(new String(buffer, 0, len, "GBK"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}