
public class MusicPlayer {
	private static boolean playing;
	private static int defaultVolume;
	private static int defaultBPM;
	private static int defaultOctave;
//	private static Instrument[] instruments;
	private static int currentInstrument;
	private static int currentVolume;
	private static int currentBPM;
	private static int currentOctave;
	
	public MusicPlayer() {
		playing = false;
		defaultVolume = 50;
		defaultBPM = 220;
		defaultOctave = 1;
//		instruments[1] = new Instrument();
//		instruments[0] = new Instrument();
		currentInstrument = 0;
		currentVolume = defaultVolume;
		currentBPM = defaultBPM;
		currentOctave = defaultOctave;
	}

	public static void Play() {
		Sound.Initialize();
		Reader.resetPos();
		String selectedCommand = new String();
		String previousCommand = new String();
		
		playing = true; // A mudan�a de playing para false ser� feita posteriormente pela interface do usu�rio
		
		while( playing ) {
			
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
					playing = false;
					break;
				default:
					if ("ABCDEFG".indexOf(Reader.getLastCommandCode()) != -1) {
						Commands.PlayNote(Reader.getLastCommandCode().charAt(0));
					}
					else {
						Commands.DoNothing();
					}
			}
			previousCommand = selectedCommand;
		}
		Sound.playMusic();

	}
	public static void Pause() {
		playing = false;
	}
	public static void Stop() {
		Reader.resetPos();
		playing = false;
		
		currentInstrument = 0;
		currentVolume = defaultVolume;
		currentBPM = defaultBPM;
		currentOctave = defaultOctave;
	}
	
	public static boolean isPlaying() {
		return playing;
	}	
	public static int getDefaultVolume() {
		return defaultVolume;
	}
	public static void setDefaultVolume(int newDefaultVolume) {
		defaultVolume = newDefaultVolume;
	}
	public static int getDefaultBPM() {
		return defaultBPM;
	}
	public static void setDefaultBPM(int newDefaultBPM) {
		defaultBPM = newDefaultBPM;
	}
	public static int getDefaultOctave() {
		return defaultOctave;
	}
	public static void setDefaultOctave(int newDefaultOctave) {
		defaultOctave = newDefaultOctave;
	}
//	public static Instrument[] getInstruments() {
//		return instruments;
//	}
//	public static void setInstruments(Instrument[] newInstruments) {
//		instruments[1] = newInstruments[1];
//		instruments[0] = newInstruments[0];
//	}
	public static int getCurrentInstrument() {
		return currentInstrument;
	}
	public static void setCurrentInstrument(int newCurrentInstrument) {
		currentInstrument = newCurrentInstrument;
	}
	public static int getCurrentVolume() {
		return currentVolume;
	}
	public static void setCurrentVolume(int newCurrentVolume) {
		currentVolume = newCurrentVolume;
	}
	public static int getCurrentBPM() {
		return currentBPM;
	}
	public static void setCurrentBPM(int newCurrentBPM) {
		currentBPM = newCurrentBPM;
	}
	public static int getCurrentOctave() {
		return currentOctave;
	}
	public static void setCurrentOctave(int newCurrentOctave) {
		currentOctave = newCurrentOctave;
	}
}
