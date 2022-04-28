public class Commands{
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

    public static void ChangeInstrument(int newInstrument){
        Sound.setInstrument(newInstrument);
    }

    public static void DoNothing(){
        Sound.addPause();
    }

    public static void IncreaseInstrument(int increment){
        int oldInstrument = Sound.getCurrentInstrument();
        Sound.setInstrument(oldInstrument + increment);
    }
}
