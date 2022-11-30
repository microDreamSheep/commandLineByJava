package live.midreamsheep.command.control;

import live.midreamsheep.command.data.variable.GlobalVariable;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CoreController {
    private final Scanner s = new Scanner(System.in);
    public void Start(){
        while (!GlobalVariable.IS_EXIT){
            System.out.print(GlobalVariable.prefix+GlobalVariable.SEPARATE);
            String in = s.nextLine();
            switch (in.trim()){
                case "exit":
                    GlobalVariable.IS_EXIT = true;
                    break;
                case "":
                    break;
                default:
                    String[] args = parse(in);
                    CommandManager.getController(args[0]).control(args);
            }
        }
    }
    private String[] parse(String in){
        List<String> list = new LinkedList<>();
        char[] chars = in.toCharArray();
        boolean StringFlag = false;
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '"'){
                StringFlag = !StringFlag;
                if(!StringFlag){
                    i++;
                    end = i;
                    list.add(in.substring(in.indexOf("\"",start)+1,in.indexOf("\"",end-1)).trim());
                    start = end;
                }
                continue;
            }
            if(StringFlag){
                end++;
                continue;
            }
            if(chars[i] != ' '){
                end++;
                continue;
            }
            if(chars[i] == ' '){
                if(start==end||in.substring(start,end).trim().equals("")){
                    start = i+1;
                    end = i+1;
                    continue;
                }
                list.add(in.substring(start,end));
                start = i+1;
                end = i+1;
            }

        }
        if(start != end){
            list.add(in.substring(start,end));
        }
        return list.toArray(new String[0]);
    }
}