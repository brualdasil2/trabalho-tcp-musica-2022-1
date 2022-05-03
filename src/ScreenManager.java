import java.awt.Image;
import java.io.IOException;
import javax.swing.*;

public class ScreenManager {
	private Screen currentScreen;
	private Screen editorScreen, settingsScreen, helpScreen;
	
	public ScreenManager(Display display) throws IOException {		
		editorScreen = new EditorScreen(this);
		settingsScreen = new SettingsScreen(this);
		
		display.addScreen(editorScreen);
		display.addScreen(settingsScreen);
		
		//primeira tela
		editorScreen.activate();
		
		currentScreen = editorScreen;
	}
	
	public void changeScreen(Screen newScreen) {
		currentScreen.deactivate();
		newScreen.activate();
		currentScreen = newScreen;
	}
	
	public Screen getEditorScreen() {
		return editorScreen;
	}
	public Screen getSettingsScreen() {
		return settingsScreen;
	}
	public static Icon resizeIcon(Image img, JButton button) {
	    Image resizedImage = img.getScaledInstance(button.getWidth(), button.getHeight(),  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}
