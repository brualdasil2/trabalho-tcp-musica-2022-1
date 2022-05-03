
public class MusicBuilder {
	private Reader reader;
	
	public MusicBuilder() {
		reader = new Reader();
	}
	
	public Sound buildMusic() {
		Sound song = new Sound();
		reader.resetPos();
		String selectedCommand;
		String previousCommand = "a";
		boolean recording = true;
		
		Commands commands = new Commands(song);
		
		while( recording ) {
			
			selectedCommand = reader.read();
			System.out.println("leu " + selectedCommand);
					
			if (isSubstringOf(selectedCommand, "ABCDEFG")) {
				commands.PlayNote(selectedCommand.charAt(0));
			}
			else if (isSubstringOf(selectedCommand, "abcdefgjklmnpqrstvwxzJKLMNPQRSTVWXZ")) {
				if (isSubstringOf(previousCommand, "ABCDEFG")) {
					commands.PlayNote(previousCommand.charAt(0));
				}
				else {
					commands.DoNothing();
				}
			}
			else if (" ".equals(selectedCommand)) {
				commands.IncreaseVolume();
			}
			else if ("!".equals(selectedCommand)) {
				commands.ChangeInstrument(Commands.AGOGO);
			}
			else if (isSubstringOf(selectedCommand, "OIUoiu")) {
				commands.ChangeInstrument(Commands.HARPSICHORD);
			}
			else if (Character.isDigit(selectedCommand.charAt(0))) {
				commands.ChangeInstrument(song.getCurrentInstrument().getMidiCode() + Integer.parseInt(selectedCommand));
			}
			else if (isSubstringOf(selectedCommand, "?.")) {
				commands.IncreaseOctave();
			}
			else if (isSubstringOf(selectedCommand, System.lineSeparator())) {
				commands.ChangeInstrument(Commands.TUBULAR_BELLS);
			}
			else if (";".equals(selectedCommand)) {
				commands.ChangeInstrument(Commands.PAN_FLUTE);
			}
			else if (",".equals(selectedCommand)) {
				commands.ChangeInstrument(Commands.CHURCH_ORGAN);
			}
			else if ("END".equals(selectedCommand)) {
				recording = false;
			}
			else {
				if (isSubstringOf(previousCommand, "ABCDEFG")) {
					commands.PlayNote(previousCommand.charAt(0));
				}
				else {
					commands.DoNothing();
				}
			}			
			previousCommand = selectedCommand;	
		}
		return song;
	}
	private static boolean isSubstringOf(String substring, String list) {
		return list.indexOf(substring) != -1;
	}
	public void reset() {
		reader.resetPos();
	}
	public Reader getReader() {
		return reader;
	}
}
