import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class HelloWorld {
	public static void main(String[] args) {
		Sound.Initialize();
		Commands.PlayNote('C');
		Commands.PlayNote('D');
		Commands.PlayNote('E');
		Commands.PlayNote('F');
		Commands.PlayNote('G');
		Commands.PlayNote('A');
		Commands.PlayNote('B');
		Commands.IncreaseOctave();
		Commands.PlayNote('C');
		Commands.PlayNote('D');
		Commands.PlayNote('E');
		Commands.PlayNote('F');
		Commands.PlayNote('G');
		Commands.PlayNote('A');
		Commands.PlayNote('B');
		Commands.DoNothing();
		Commands.ChangeInstrument(114);
		Commands.PlayRandomNote();
		Commands.PlayRandomNote();
		Commands.PlayRandomNote();
		Commands.DoNothing();
		Sound.playMusic();

	}
}
