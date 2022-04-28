import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.NumberFormatter;

public class SettingsScreen extends Screen {

	public SettingsScreen(ScreenManager screenManager) throws IOException {
		super(screenManager);
		panel.setBackground(Color.BLACK);
		Font titleFont = new Font("sans-serif", Font.PLAIN, 24);
		Font defaultFont = new Font("sans-serif", Font.PLAIN, 18);
		String[] octavesList = {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8"};
		
		Image returnImage = ImageIO.read(getClass().getResource("resources/return-button.png"));
		JLabel title = new JLabel("Configurações");
		JLabel volume = new JLabel("Volume Padrão (0 - 100)");
		JLabel bpm = new JLabel("BPM Padrão (80 - 180)");
		JLabel octave = new JLabel("Oitava Padrão");
		JTextField volumeField = new JTextField("50");
		JTextField bpmField = new JTextField("120");
		JComboBox<String> dropDownOctaves = new JComboBox<String>(octavesList);

		JButton navButton = new JButton();
		JTextArea textArea = new JTextArea("Volume Padrão");
		
		title.setFont(titleFont);
		title.setForeground(Color.WHITE);
		volume.setForeground(Color.WHITE);
		bpm.setForeground(Color.WHITE);
		octave.setForeground(Color.WHITE);
		
		title.setBounds(500, 10, 200, 200);
		volume.setBounds(400, 100, 200, 200);
		bpm.setBounds(400, 150, 200, 200);
		octave.setBounds(400, 200, 200, 200);
		volumeField.setBounds(600, 190, 100, 20);
		bpmField.setBounds(600, 240, 100, 20);
		navButton.setBounds(10, 10, 50, 50);
		dropDownOctaves.setBounds(600, 290, 100, 20);
		
		
		Icon returnIcon = ScreenManager.resizeIcon(returnImage, navButton);
		navButton.setIcon(returnIcon);
		navButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Mudou tela!");
				screenManager.changeScreen(screenManager.getEditorScreen());
			}
			
		});
		
		volumeField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(volumeField.getText());
				if(value >= 0 && value <= 100) {
					System.out.println(value);
				}
				else {
					System.out.println("Valor Invalido");
					volumeField.setText("50");
				}
			}
			
		});
		
		bpmField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(bpmField.getText());
				if(value >= 80 && value <= 180) {
					System.out.println(value);
				}
				else {
					System.out.println("Valor Invalido");
					bpmField.setText("120");
				}
			}
			
		});
		
		dropDownOctaves.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println(dropDownOctaves.getSelectedItem());
			}
			
		});
		
		panel.add(title);
		panel.add(volume);
		panel.add(bpm);
		panel.add(octave);
		panel.add(volumeField);
		panel.add(bpmField);
		panel.add(bpm);
		panel.add(dropDownOctaves);
		panel.add(navButton);
	}
	
}
