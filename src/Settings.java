public class Settings {
	
	public static final int OUT_OF_RANGE = -1;
	public static final int OK = 0;
	
	private static int defaultVolume = 24;
	private static int defaultBPM = 60;
	private static int defaultOctave = 3;
	
	public static int setDefaultVolume(int volume) {
		if (volume > Sound.MAX_VOLUME)
			return OUT_OF_RANGE;
		if (volume < Sound.MIN_VOLUME)
			return OUT_OF_RANGE;
		defaultVolume = volume;
		return OK;
	}
	public static int setDefaultBPM(int bpm) {
		if (bpm > Sound.MAX_BPM)
			return OUT_OF_RANGE;
		if (bpm < Sound.MIN_BPM)
			return OUT_OF_RANGE;
		defaultBPM = bpm;
		return OK;
	}
	public static int setDefaultOctave(int octave) {
		if (octave > Sound.MAX_OCTAVE)
			return OUT_OF_RANGE;
		if (octave < Sound.MIN_OCTAVE)
			return OUT_OF_RANGE;
		defaultOctave = octave;
		return OK;
	}
	
	public static int getDefaultVolume() {
		return defaultVolume;
	}
	public static int getDefaultBPM() {
		return defaultBPM;
	}
	public static int getDefaultOctave() {
		return defaultOctave;
	}
}
