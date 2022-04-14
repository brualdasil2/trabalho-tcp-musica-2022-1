import org.jfugue.pattern.Pattern;
import org.jfugue.player.*;

public class Sound {
	
	
	Player player = new Player();
	int currentOctave = 5;
	int currentBPM = 60;
	int currentVolume = 40;
	String currentInstrument = "PIANO";
	Pattern music = new Pattern();
	
	public Sound() {
		music.setTempo(currentBPM);
		setVolume(currentVolume);
		setInstrument(currentInstrument);
	}
	

	
	public void playMusic() {
		System.out.println(music.toString());
		player.play(music);
	}
	
	public void addNote(char note) {
		music.add(note + Integer.toString(currentOctave) + "q");
	}
	
	public void addPause() {
		music.add("R");
	}
	
	public void setBPM(int bpm) {
		currentBPM = bpm;
		music.add("T" + Integer.toString(currentBPM));
	}
	
	public void setVolume(int vol) {
		currentVolume = vol;
		music.add(":CON(7, " + Integer.toString(currentVolume) + ")");
	}
	
	public void setInstrument(String instrument) {
		currentInstrument = instrument;
		music.add("I[" + instrument + "]");
	}
	
	public int getCurrentBPM() {
		return currentBPM;
	}
}
