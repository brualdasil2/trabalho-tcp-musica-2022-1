import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
public class HelloWorld {
	public static void main(String[] args) {

		Display display = new Display("Toca musica", 1280, 720);
		ScreenManager sm = new ScreenManager(display);

	}
}
