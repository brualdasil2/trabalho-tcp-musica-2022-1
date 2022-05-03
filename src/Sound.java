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
	
	private Player player = new Player();
	private int currentOctave;
	private int currentBPM;
	private int currentVolume;
	private Instrument currentInstrument;
	private Pattern music;
	
	public Sound() {
		music = new Pattern();
		currentInstrument = new Instrument();
		setBPM(Settings.getDefaultBPM());
		setVolume(Settings.getDefaultVolume());
		setOctave(Settings.getDefaultOctave());
	}
	/*
	public static void Initialize() {
		music = new Pattern();
		currentInstrument = new Instrument();
		setBPM(Settings.getDefaultBPM());
		setVolume(Settings.getDefaultVolume());
		setOctave(Settings.getDefaultOctave());
	*/

	public void playNote(char note) {
		Pattern m = new Pattern();
		m.add("T" + Integer.toString(currentBPM));
		m.add(":CON(7, " + Integer.toString(currentVolume) + ")");
		m.add("I" + currentInstrument );
		m.add(note + Integer.toString(currentOctave) + "q");
		player.play(m);
	}
	
	public void playMusic() {
		player.play(music);
	}
	
	public void pauseMusic() {
		player.getManagedPlayer().pause();
	}
	public void resumeMusic() {
		player.getManagedPlayer().resume();
	}
	public void stopMusic() {
		player.getManagedPlayer().finish();
	}
	
	public void createMidiFile(String path) {
		File file = new File(path);
		try {
			MidiFileManager.savePatternToMidi(music, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void setOctave(int octave) {
		if(octave > MAX_OCTAVE){
			currentOctave = MIN_OCTAVE;
		}else {
			currentOctave = octave;
		}
	}
	
	public void setVolume(int vol) {
		if(vol > MAX_VOLUME){
			currentVolume = MIN_VOLUME;
		}else {
			currentVolume = vol;
		}
		music.add(":CON(7, " + Integer.toString(currentVolume) + ")");
	}

	public void setInstrument(Instrument newInstrument) {
		currentInstrument = newInstrument;
		music.add("I" + newInstrument.getMidiCode()  );
	}

	public int getCurrentBPM() {
		return currentBPM;
	}

	public int getVolume(){
		return currentVolume;
	}

	public int getCurrentOctave(){
		return currentOctave;
	}

	public Instrument getCurrentInstrument(){
		return currentInstrument;
	}
}
