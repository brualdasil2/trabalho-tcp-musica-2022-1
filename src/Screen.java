import javax.swing.*;

public abstract class Screen {
	protected JPanel panel;
	
	public Screen(ScreenManager screenManager) {
		panel = new JPanel();
		panel.setBounds(0, 0, Display.getWidth(), Display.getHeight());
		panel.setLayout(null);
		panel.setVisible(false);
	}
	
	public void activate() {
		panel.setVisible(true);
	}
	
	public void deactivate() {
		panel.setVisible(false);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
