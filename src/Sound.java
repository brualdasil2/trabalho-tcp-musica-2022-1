import java.io.File;
import java.io.IOException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.*;

public class Sound {

	
	private static Player player = new Player();
	private static int currentOctave;
	private static int currentBPM;
	private static int currentVolume;
	private static String currentInstrument;
	private static Pattern music;
	
	public static void Initialize() {
		music = new Pattern();
		setBPM(60);
		setVolume(90);
		setInstrument("PIANO");
		setOctave(5);
	}

	public static void playNote(char note) {
		Pattern m = new Pattern();
		m.add("T" + Integer.toString(currentBPM));
		m.add(":CON(7, " + Integer.toString(currentVolume) + ")");
		m.add("I[" + currentInstrument + "]");
		m.add(note + Integer.toString(currentOctave) + "q");
		player.play(m);
	}
	
	public static void playMusic() {
		player.play(music);
	}
	
	public static void createMidiFile(String path) {
		File file = new File(path);
		try {
			MidiFileManager.savePatternToMidi(music, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addNote(char note) {
		music.add(note + Integer.toString(currentOctave) + "q");
	}
	
	public static void addPause() {
		music.add("R");
	}
	
	public static void setBPM(int bpm) {
		currentBPM = bpm;
		music.add("T" + Integer.toString(currentBPM));
	}
	
	public static void setOctave(int octave) {
		currentOctave = octave;
	}
	
	public static void setVolume(int vol) {
		currentVolume = vol;
		music.add(":CON(7, " + Integer.toString(currentVolume) + ")");
	}
	
	public static void setInstrument(String instrument) {
		currentInstrument = instrument;
		music.add("I[" + instrument + "]");
	}
	
	public static int getCurrentBPM() {
		return currentBPM;
	}
}
