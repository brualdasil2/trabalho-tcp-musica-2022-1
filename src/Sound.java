import java.io.File;
import java.io.IOException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.*;

public class Sound {
	private static final int MinVolume = 24;
	private static final int MaxVolume = 4*MinVolume;
	private static final int DefaultVolume = MaxVolume;

	private static final int MinOctave = 3;
	private static final int MaxOctave = 9;
	private static final int DefaultOctave = 5;

	private static final int DefaultBPM = 30;
	private static final int DefaultInstrument = 0; //Piano

	private static Player player = new Player();
	private static int currentOctave;
	private static int currentBPM;
	private static int currentVolume;
	private static int currentInstrument;
	private static Pattern music;
	
	public static void Initialize() {
		music = new Pattern();
		setBPM(DefaultBPM);
		setVolume(DefaultVolume);
		setInstrument(DefaultInstrument);
		setOctave(DefaultOctave);
	}

	public static void playNote(char note) {
		Pattern m = new Pattern();
		m.add("T" + Integer.toString(currentBPM));
		m.add(":CON(7, " + Integer.toString(currentVolume) + ")");
		m.add("I" + currentInstrument );
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
		if(octave > MaxOctave){
			currentOctave = MinOctave;
		}else {
			currentOctave = octave;
		}
	}
	
	public static void setVolume(int vol) {
		if(vol > MaxVolume){
			currentVolume = MinVolume;
		}else {
			currentVolume = vol;
		}
		music.add(":CON(7, " + Integer.toString(currentVolume) + ")");
	}

	public static void setInstrument(int instrument) {
		currentInstrument = instrument;
		music.add("I" + instrument  );
	}

	public static int getCurrentBPM() {
		return currentBPM;
	}

	public static int getVolume(){
		return currentVolume;
	}

	public static int getCurrentOctave(){
		return currentOctave;
	}

	public static int getCurrentInstrument(){
		return currentInstrument;
	}
}
