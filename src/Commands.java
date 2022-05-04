public class Commands {
	
	public static final int AGOGO = 114;
	public static final int HARPSICHORD = 7;
	public static final int TUBULAR_BELLS = 15;
	public static final int PAN_FLUTE = 76;
	public static final int CHURCH_ORGAN = 114;
	
    public static void PlayNote(char note){
        Sound.addNote(note);
    }

    public static void IncreaseOctave(){
        Sound.setOctave(Sound.getCurrentOctave()+1);
    }

    public static void IncreaseVolume(){
        Sound.setVolume(2*Sound.getVolume());
    }

    public static void PlayRandomNote(){
        String possibleNotes = "ABCDEFG";
        char randomNote = possibleNotes.toCharArray()[(int)(Math.random() * possibleNotes.length())];
        PlayNote(randomNote);
    }

    public static void ChangeInstrument(int newCode){
        Sound.setInstrument(new Instrument(newCode));
    }

    public static void DoNothing(){
        Sound.addPause();
    }

    public static void IncreaseInstrument(int increment){
        int currentCode = Sound.getCurrentInstrument().getMidiCode();
        Sound.setInstrument(new Instrument(currentCode + increment));
    }
}
