import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class Display {
	private JFrame frame;
	private static int width, height;
	
	public Display(String title, int width, int height) {
		Display.width = width;
		Display.height = height;
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addScreen(Screen screen) {
		frame.add(screen.getPanel());
		frame.repaint();
	}
	
	public static int getWidth() {
		return width;
	}
	public static int getHeight() {
		return height;
	}
}
