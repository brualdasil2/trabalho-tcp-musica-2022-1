
public class MusicPlayer {
	public static final int PLAYING = 1;
	public static final int PAUSED = 2;
	public static final int STOPPED = 3;
	
	private int status;
	private static int defaultVolume;
	private static int defaultBPM;
	private static int defaultOctave;
	private static int currentInstrument;
	private static int currentVolume;
	private static int currentBPM;
	private static int currentOctave;
	
	private Thread playThread;  
	private MusicBuilder builder;
	private Sound song;
	
	public MusicPlayer() {
		status = MusicPlayer.STOPPED;
		builder = new MusicBuilder();
	}

	public void Play() {
		playThread = new Thread(new Runnable() {
			@Override
			public void run() {
				aux_play();
			}
		});
		playThread.start();
	}
	
	private void aux_play() {
		if (status != STOPPED) 
			return;
		
		status = PLAYING;
		
		song = builder.buildMusic();
		song.playMusic();
		Stop();
	}
	public void Pause() {
		if (status != PLAYING)
			return;
		status = PAUSED;
		song.pauseMusic();
	}
	public void Stop() {
		
		builder.reset();
		status = STOPPED;
		song.stopMusic();
		playThread.interrupt();
	}
	public void Resume() {
		song.resumeMusic();
		status = PLAYING;
	}
	
	public MusicBuilder getBuilder() {
		return builder;
	}
	
	public boolean isPlaying() {
		return status == PLAYING;
	}	
	public boolean isPaused() {
		return status == PAUSED;
	}
	public boolean isStopped() {
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
