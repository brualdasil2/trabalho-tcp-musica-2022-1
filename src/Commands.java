public class Commands {
	
	public static final int AGOGO = 114;
	public static final int HARPSICHORD = 7;
	public static final int TUBULAR_BELLS = 15;
	public static final int PAN_FLUTE = 76;
	public static final int CHURCH_ORGAN = 114;
	
	private Sound song;
	
	public Commands(Sound song) {
		this.song = song;
	}
	
    public void PlayNote(char note){
        song.addNote(note);
    }

    public void IncreaseOctave(){
        song.setOctave(song.getCurrentOctave()+1);
    }

    public void IncreaseVolume(){
    	song.setVolume(2*song.getVolume());
    }

    public void PlayRandomNote(){
        String possibleNotes = "ABCDEFG";
        char randomNote = possibleNotes.toCharArray()[(int)(Math.random() * possibleNotes.length())];
        PlayNote(randomNote);
    }

    public void ChangeInstrument(int newCode){
    	song.setInstrument(new Instrument(newCode));
    }

    public void DoNothing(){
    	song.addPause();
    }

    public void IncreaseInstrument(int increment){
    	int currentCode = song.getCurrentInstrument().getMidiCode();
    	song.setInstrument(new Instrument(currentCode + increment));
    }
}
