public class MusicRecorder {
	
	public static void recordMusic() {
		MusicBuilder.buildMusic();
		Sound.createMidiFile("musica.midi");
	}
}
