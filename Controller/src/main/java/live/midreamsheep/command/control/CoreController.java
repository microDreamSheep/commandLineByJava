package live.midreamsheep.command.control;

import live.midreamsheep.command.data.variable.GlobalVariable;

import java.util.Scanner;

public class CoreController {
    private final Scanner s = new Scanner(System.in);
    public void Start(){
        while (!GlobalVariable.IS_EXIT){
            System.out.print(GlobalVariable.prefix+GlobalVariable.SEPARATE);
            String input = s.nextLine();
            if (input.equals("exit")){
                GlobalVariable.IS_EXIT = true;
            }else{
                String[] args = input.split(" ");
                CommandManager.getController(args[0]).control(args);
            }
        }
    }
}