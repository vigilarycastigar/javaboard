package javaboard;

import java.util.List;
import java.util.Scanner;

public class PlayerHumanTerminal extends Player {

    @SuppressWarnings("resource")
    @Override
    public Movement pickMovement(List<Movement> options, List<String> input_commands){
        assert(options.size()>0);

        // Print available moves
        System.out.print("Moves :");
        for(Movement mov : options){
            System.out.print(" "+mov.command);
        }
        System.out.println();

        // Expect comand
        Movement input_move = null;
        Scanner scan_in = new Scanner(System.in);
        while(true){
            System.out.println("> Insert movement:");
            String input = scan_in.nextLine();

            for(Movement mov : options){
                if(mov.command.equals(input)){
                    input_move = mov;
                }
            }
            if(input_move != null) break;

            System.out.println("> Invalid move!");
        }

        return input_move;
    }

    @Override
    public String victoryMessage(){
        return "Show me your moves!";
    }
}