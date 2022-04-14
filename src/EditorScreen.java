import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditorScreen extends Screen {
	
	public EditorScreen(ScreenManager screenManager) {
		super(screenManager);
		
		JButton playButton = new JButton("Play");
		JButton pauseButton = new JButton("Pause");
		JButton navButton = new JButton("Mudar tela");
		JTextArea textArea = new JTextArea();
		
		playButton.setBounds(130, 100, 100, 40);
		pauseButton.setBounds(250, 100, 100, 40);
		navButton.setBounds(10, 10, 100, 40);
		textArea.setBounds(130, 250, 300, 100);
		
		textArea.setLineWrap(true);
		
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tocando a música " + textArea.getText());
			}
			
		});
		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pause!");
			}
			
		});
		navButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Mudou tela!");
				screenManager.changeScreen(screenManager.getSettingsScreen());
			}
			
		});
		
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				System.out.println("Digitou");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				System.out.println("Apagou");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {}
			
		});

		panel.setBackground(Color.red);
		
		panel.add(playButton);
		panel.add(pauseButton);
		panel.add(navButton);
		panel.add(textArea);
	}
}
