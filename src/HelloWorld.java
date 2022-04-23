import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
public class HelloWorld {
	public static void main(String[] args) {
		Display display = new Display("Toca musica", 1280, 720);
		ScreenManager sm = new ScreenManager(display);
		Reader.setMusicString("aaa \n!.l;,?AAGCDFD ");
		String r = "";
		String read = "";
		while(read != "END"){
			read =Reader.read();
			if (read != "END"){
				r += read;
			}
		}
		System.out.println(r);
	}
}
