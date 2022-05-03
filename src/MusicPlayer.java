public class MusicPlayer {
	public static final int PLAYING = 1;
	public static final int PAUSED = 2;
	public static final int STOPPED = 3;
	
	private static int status = STOPPED;
	
	private static Thread playThread;  


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
		
		status = PLAYING;
		
		MusicBuilder.buildMusic();
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
}
