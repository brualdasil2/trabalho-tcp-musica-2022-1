import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ScreenManager {
	private Screen currentScreen;
	private Screen editorScreen, settingsScreen, helpScreen;
	
	public ScreenManager(Display display) {		
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
}
