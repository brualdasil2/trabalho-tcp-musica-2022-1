
public class MusicRecorder {
	
	public static void recordMusic() {
		Sound.Initialize();
		Reader.resetPos();
		String selectedCommand;
		String previousCommand = "a";
		boolean recording = true;
		
		while( recording ) {
			
			selectedCommand = Reader.read();
					
			if ("ABCDEFG".indexOf(selectedCommand) != -1) {
				Commands.PlayNote(selectedCommand.charAt(0));
			}
			else if ("abcdefgjklmnpqrstvwxzJKLMNPQRSTVWXZ".indexOf(selectedCommand) != -1) {
				if ("ABCDEFG".indexOf(previousCommand) != -1) {
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
				Commands.ChangeInstrument(114);//Agogo
			}
			else if ("OIU".indexOf(selectedCommand) != -1) {
				Commands.ChangeInstrument(7);//Harpsichord
			}
			else if (Character.isDigit(selectedCommand.charAt(0))) {
				Commands.ChangeInstrument(Sound.getCurrentInstrument() + Integer.parseInt(selectedCommand));
			}
			else if ("?.".indexOf(selectedCommand) != -1) {
				Commands.IncreaseOctave();
			}
			else if ("\n".equals(selectedCommand)) {
				Commands.ChangeInstrument(15);//Tubular Bells
			}
			else if (";".equals(selectedCommand)) {
				Commands.ChangeInstrument(76);//Pan Flute
			}
			else if (",".equals(selectedCommand)) {
				Commands.ChangeInstrument(20);//Church Organ
			}
			else if ("END".equals(selectedCommand)) {
				recording = false;
			}
			else {
				if ("ABCDEFG".indexOf(previousCommand) != -1) {
					Commands.PlayNote(previousCommand.charAt(0));
				}
				else {
					Commands.DoNothing();
				}
			}			
			previousCommand = selectedCommand;	
		}
		Sound.createMidiFile("musica.midi");
	}
		
		
	
}
