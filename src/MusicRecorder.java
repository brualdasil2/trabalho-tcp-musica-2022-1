
public class MusicRecorder {
	private MusicBuilder builder;
	private Sound song;
	
	public MusicRecorder() {
		builder = new MusicBuilder();
	}
	public void recordMusic() {
		song = builder.buildMusic();
		song.createMidiFile("musica.midi");
	}
	public MusicBuilder getBuilder() {
		return builder;
	}
}
