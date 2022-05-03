import java.io.*;
import java.util.*;

public class Reader {
    private int currentPos;
    private String musicString;

    public Reader() {
    	currentPos = 0;
    }
    
    public String read(){
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

    public void setMusicString(String newString){
        musicString = newString;
    }

    public void resetPos() { currentPos = 0; }
    public int GetCurrentPos(){
        return currentPos;
    }
    private Boolean isValidCommand(String command){
        String[] validCommands = {" ","!","?",".",System.lineSeparator(),";",","};
        for (String s : validCommands) {
            if(s.indexOf(command) != -1){
                return true;
            }
        }
        if(Character.isLetter(command.charAt(0)) || Character.isDigit(command.charAt(0))){
            return true;
        }
        return false;
    }
    
}


