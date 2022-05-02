import java.io.*;
import java.util.*;

public class Reader {
    private static int currentPos = 0;
    private static String musicString;

    public static String read(){
        String currentCommand;
        try {
            currentCommand = Character.toString(musicString.charAt(currentPos));
        }
        catch(Exception e) {
            return "END";
        }
        currentPos ++;
        if( !isValidCommand(currentCommand) ){
            return "ELSE";
        }
        return currentCommand;
    }

    // chamado na interface
    public static void setMusicString(String newString){
        musicString = newString;
    }

    public static void resetPos() { currentPos = 0; }
    public static int GetCurrentPos(){
        return currentPos;
    }
    private static Boolean isValidCommand(String command){
        String[] validCommands = {" ","!","?",".",System.lineSeparator(),";",","};
        for (String s : validCommands) {
            if(command.charAt(0) == s.charAt(0)){
                return true;
            }
        }
        if(Character.isLetter(command.charAt(0)) || Character.isDigit(command.charAt(0))){
            return true;
        }
        return false;
    }
}


