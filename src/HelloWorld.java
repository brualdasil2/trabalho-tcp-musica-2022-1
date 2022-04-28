import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class HelloWorld {
	public static void main(String[] args) {
		Sound.Initialize();
		//justify volumes 24 -> 48 ->96 -> 24 ( does not pass 100 ) 96 is the best, hence default
		Commands.PlayNote('C');
		Commands.IncreaseVolume();
		Commands.PlayNote('C');
		Commands.IncreaseVolume();
		Commands.PlayNote('C');
		Commands.IncreaseVolume();
		Commands.PlayNote('C');
		// justify octave 3 -> 9 , 5 is the best, hence default
		Commands.PlayNote('B');
		Commands.IncreaseOctave();
		Commands.PlayNote('B');
		Commands.IncreaseOctave();
		Commands.PlayNote('B');
		Commands.IncreaseOctave();
		Commands.PlayNote('B');
		Commands.IncreaseOctave();
		Commands.PlayNote('B');
		Commands.IncreaseOctave();
		Commands.PlayNote('B');

		Sound.playMusic();

	}
}
