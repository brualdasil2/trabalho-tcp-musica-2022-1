import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class HelloWorld {
	public static void main(String[] args) throws IOException {
		Display display = new Display("Toca musica", 1280, 720);
		ScreenManager sm = new ScreenManager(display);
	}
}
