
public class MusicPlayer {
	public static final int PLAYING = 1;
	public static final int PAUSED = 2;
	public static final int STOPPED = 3;
	
	private static int status = STOPPED;
	private static int defaultVolume;
	private static int defaultBPM;
	private static int defaultOctave;
//	private static Instrument[] instruments;
	private static int currentInstrument;
	private static int currentVolume;
	private static int currentBPM;
	private static int currentOctave;
	
	private static Thread playThread;  
	
	public MusicPlayer() {
		//playing = false;
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
		playThread = new Thread(new Runnable() {
			@Override
			public void run() {
				MusicPlayer.aux_play();
			}
		});
		playThread.start();
	}
	
	private static void aux_play() {
		if (status != STOPPED) 
			return;
		
		Sound.Initialize();
		Reader.resetPos();
		String selectedCommand;
		String previousCommand = "a";
		
		status = PLAYING;
		boolean building = true;
		
		while( building ) {
			
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
				building = false;
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
		Sound.playMusic();
		Stop();
	}
	public static void Pause() {
		if (status != PLAYING)
			return;
		status = PAUSED;
		Sound.pauseMusic();
	}
	public static void Stop() {
		
		Reader.resetPos();
		status = STOPPED;
		Sound.stopMusic();
		playThread.interrupt();
	}
	public static void Resume() {
		Sound.resumeMusic();
		status = PLAYING;
	}
	
	public static boolean isPlaying() {
		return status == PLAYING;
	}	
	public static boolean isPaused() {
		return status == PAUSED;
	}
	public static boolean isStopped() {
		return status == STOPPED;
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
