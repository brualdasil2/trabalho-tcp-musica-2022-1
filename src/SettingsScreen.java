import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SettingsScreen extends Screen {

	public SettingsScreen(ScreenManager screenManager) {
		super(screenManager);
		
		JLabel title = new JLabel("Configurações");
		JButton navButton = new JButton("Mudar tela");
		
		title.setBounds(200, 200, 100, 100);
		navButton.setBounds(10, 10, 100, 40);
		
		navButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Mudou tela!");
				screenManager.changeScreen(screenManager.getEditorScreen());
			}
			
		});
		
		panel.add(title);
		panel.add(navButton);
	}
	
}
