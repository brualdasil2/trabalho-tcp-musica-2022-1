
public class MusicRecorder {
	
	public static void recordMusic() {
		Sound.Initialize();
		Reader.resetPos();
		String selectedCommand;
		boolean recording = true;
		while( recording ) {
			
			selectedCommand = Reader.read();
					
			switch (selectedCommand) {
				case "A":
				case "B":
				case "C":
				case "D":
				case "E":
				case "F":
				case "G":
					Commands.PlayNote(selectedCommand.charAt(0));
					break;
				case "a":
				case "b":
				case "c":
				case "d":
				case "e":
				case "f":
				case "g":
					
				case "J":
				case "K":
				case "L":
				case "M":
				case "N":
				case "P":
				case "Q":
				case "R":
				case "S":
				case "T":
				case "V":
				case "W":
				case "X":
				case "Z":
					if ("ABCDEFG".indexOf(Reader.getLastCommandCode()) != -1) {
						Commands.PlayNote(Reader.getLastCommandCode().charAt(0));
					}
					else {
						Commands.DoNothing();
					}
					break;
				case " ":
					Commands.IncreaseVolume();
					break;
				case "!":
					Commands.ChangeInstrument(114);//Agogo
				case "O":
				case "I":
				case "U":
					Commands.ChangeInstrument(7);//Harpsichord
					break;
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					Commands.ChangeInstrument(Sound.getCurrentInstrument() + Integer.parseInt(selectedCommand));
					break;
				case "?":
				case ".":
					Commands.IncreaseOctave();
					break;
				case "\n":
					Commands.ChangeInstrument(15);//Tubular Bells
					break;
				case ";":
					Commands.ChangeInstrument(76);//Pan Flute
					break;
				case ",":
					Commands.ChangeInstrument(20);//Church Organ
					break;
				case "END":
					recording = false;
					break;
				default:
					if ("ABCDEFG".indexOf(Reader.getLastCommandCode()) != -1) {
						Commands.PlayNote(Reader.getLastCommandCode().charAt(0));
					}
					else {
						Commands.DoNothing();
					}
				}
			}
		Sound.createMidiFile("musica.midi");
	}
		
		
	
}
