public class Instrument {
	private int midiCode;
	private static final int MIN_CODE = 0;
	private static final int MAX_CODE = 128;
	
	public Instrument() {
		midiCode = 0;
	}
	public Instrument(int midiCode) {
		setMidiCode(midiCode);
	}
	
	public int getMidiCode() {
		return midiCode;
	}
	public void setMidiCode(int newCode) {
		if (newCode > Instrument.MAX_CODE) {
			midiCode = Instrument.MIN_CODE;
		}
		else {
			midiCode = newCode;
		}
	}
}
