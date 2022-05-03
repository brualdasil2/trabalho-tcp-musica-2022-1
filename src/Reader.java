public class Reader {
	
	public static final String END = "END";
	public static final String ELSE = "ELSE";
	
    private static int currentPos = 0;
    private static String musicString;

    public static String read(){
        String currentCommand;
        try {
            currentCommand = Character.toString(musicString.charAt(currentPos));
        }
        catch(Exception e) {
            return END;
        }
        currentPos ++;
        if(currentCommand.equals("\r")) {
        	currentPos ++;
        	return "\n";
        }
        if( !isValidCommand(currentCommand) ){
            return ELSE;
        }
        
        return currentCommand;
    }

    public static void setMusicString(String newString){
        musicString = newString;
    }

    public static void resetPos() { currentPos = 0; }
    public static int GetCurrentPos(){
        return currentPos;
    }
    private static Boolean isValidCommand(String command){
        String[] validCommands = {" ","!","?",".","\n",";",","};
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


