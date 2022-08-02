package live.midreamsheep.command.control;

import live.midreamsheep.command.data.variable.GlobalVariable;

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
                    String[] args = in.trim().split(" ");
                    CommandManager.getController(args[0]).control(args);
            }
        }
    }
}