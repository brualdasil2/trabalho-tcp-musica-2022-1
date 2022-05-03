import java.io.File;
import java.io.IOException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.*;

public class Sound {
	public static final int MIN_VOLUME = 24;
	public static final int MAX_VOLUME = 4*MIN_VOLUME;

	public static final int MIN_OCTAVE = 3;
	public static final int MAX_OCTAVE = 9;

	public static final int MIN_BPM = 1;
	public static final int MAX_BPM = 60; 
	
	public static final int MIN_INSTRUMENT = 0;
	public static final int MAX_INSTRUMENT = 128;

	private static final int DEFAULT_INSTRUMENT = MIN_INSTRUMENT;
	
	private static Player player = new Player();
	private static int currentOctave;
	private static int currentBPM;
	private static int currentVolume;
	private static int currentInstrument;
	private static Pattern music;
	
	public static void Initialize() {
		music = new Pattern();
		setBPM(Settings.getDefaultBPM());
		setVolume(Settings.getDefaultVolume());
		setInstrument(DEFAULT_INSTRUMENT);
		setOctave(Settings.getDefaultOctave());
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
	
	public static void pauseMusic() {
		player.getManagedPlayer().pause();
	}
	public static void resumeMusic() {
		player.getManagedPlayer().resume();
	}
	public static void stopMusic() {
		player.getManagedPlayer().finish();
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
		if(octave > MAX_OCTAVE){
			currentOctave = MIN_OCTAVE;
		}else {
			currentOctave = octave;
		}
	}
	
	public static void setVolume(int vol) {
		if(vol > MAX_VOLUME){
			currentVolume = MIN_VOLUME;
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
