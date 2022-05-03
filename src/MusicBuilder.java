public class MusicBuilder {
	public static void buildMusic() {
		Sound.Initialize();
		Reader.resetPos();
		String selectedCommand;
		String previousCommand = "a";
		boolean recording = true;
		
		while( recording ) {
			
			selectedCommand = Reader.read();
					
			if (isSubstringOf(selectedCommand, "ABCDEFG")) {
				Commands.PlayNote(selectedCommand.charAt(0));
			}
			else if (isSubstringOf(selectedCommand, "abcdefgjklmnpqrstvwxzJKLMNPQRSTVWXZ")) {
				if (isSubstringOf(previousCommand, "ABCDEFG")) {
					Commands.PlayNote(previousCommand.charAt(0));
				}
				else {
					Commands.DoNothing();
				}
			}
			else if (" ".equals(selectedCommand)) {
				Commands.IncreaseVolume();
			}
			else if ("!".equals(selectedCommand)) {
				Commands.ChangeInstrument(Commands.AGOGO);
			}
			else if (isSubstringOf(selectedCommand, "OIUoiu")) {
				Commands.ChangeInstrument(Commands.HARPSICHORD);
			}
			else if (Character.isDigit(selectedCommand.charAt(0))) {
				Commands.ChangeInstrument(Sound.getCurrentInstrument() + Integer.parseInt(selectedCommand));
			}
			else if (isSubstringOf(selectedCommand, "?.")) {
				Commands.IncreaseOctave();
			}
			else if (isSubstringOf(selectedCommand, System.lineSeparator())) {
				Commands.ChangeInstrument(Commands.TUBULAR_BELLS);
			}
			else if (";".equals(selectedCommand)) {
				Commands.ChangeInstrument(Commands.PAN_FLUTE);
			}
			else if (",".equals(selectedCommand)) {
				Commands.ChangeInstrument(Commands.CHURCH_ORGAN);
			}
			else if (Reader.END.equals(selectedCommand)) {
				recording = false;
			}
			else {
				if (isSubstringOf(previousCommand, "ABCDEFG")) {
					Commands.PlayNote(previousCommand.charAt(0));
				}
				else {
					Commands.DoNothing();
				}
			}			
			previousCommand = selectedCommand;	
		}
	}
	private static boolean isSubstringOf(String substring, String list) {
		return list.indexOf(substring) != -1;
	}
}
