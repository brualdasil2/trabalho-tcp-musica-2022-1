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
		String[] octavesList = {"3", "4", "5", "6", "7", "8", "9"};
		
		Image returnImage = ImageIO.read(getClass().getResource("resources/return-button.png"));
		JLabel title = new JLabel("Configurações");
		JLabel volume = new JLabel("Volume Padrão (" + Sound.MIN_VOLUME + "-" + Sound.MAX_VOLUME + ")");
		JLabel bpm = new JLabel("BPM Padrão (" + Sound.MIN_BPM + "-" + Sound.MAX_BPM +")");
		JLabel octave = new JLabel("Oitava Padrão");
		JTextField volumeField = new JTextField("" + Settings.getDefaultVolume());
		JTextField bpmField = new JTextField("" + Settings.getDefaultBPM());
		JComboBox<String> dropDownOctaves = new JComboBox<String>(octavesList);

		JButton navButton = new JButton();
		JButton saveButton = new JButton("Salvar");
		JTextArea textArea = new JTextArea("Volume Padrão");
		
		JLabel statusVol = new JLabel(""); 
		JLabel statusBPM = new JLabel("");
		JLabel statusOctave = new JLabel(""); 
		
		title.setFont(titleFont);
		title.setForeground(Color.WHITE);
		volume.setForeground(Color.WHITE);
		bpm.setForeground(Color.WHITE);
		octave.setForeground(Color.WHITE);
		statusVol.setForeground(Color.WHITE);
		statusBPM.setForeground(Color.WHITE);
		statusOctave.setForeground(Color.WHITE);
		
		title.setBounds(500, 10, 200, 200);
		volume.setBounds(400, 100, 200, 200);
		bpm.setBounds(400, 150, 200, 200);
		octave.setBounds(400, 200, 200, 200);
		volumeField.setBounds(600, 190, 100, 20);
		bpmField.setBounds(600, 240, 100, 20);
		navButton.setBounds(10, 10, 50, 50);
		dropDownOctaves.setBounds(600, 290, 100, 20);
		saveButton.setBounds(600, 500, 100, 50);
		statusVol.setBounds(750, 190, 200, 20);
		statusBPM.setBounds(750, 240, 200, 20);
		statusOctave.setBounds(750, 290, 200, 20);
		
		
		
		Icon returnIcon = ScreenManager.resizeIcon(returnImage, navButton);
		navButton.setIcon(returnIcon);
		navButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				statusVol.setText("");
				statusBPM.setText("");
				statusOctave.setText("");
				screenManager.changeScreen(screenManager.getEditorScreen());
			}
			
		});
		

		
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int parsedVolume = Integer.parseInt(volumeField.getText());
					if (Settings.setDefaultVolume(parsedVolume) == Settings.OUT_OF_RANGE) {
						statusVol.setText("Valor invalido!");
					}
					else {
						statusVol.setText("Salvo!");
					}
				}
				catch (NumberFormatException ex){
					statusVol.setText("Valor deve ser inteiro!");
				}
				
				try {
					int parsedBPM = Integer.parseInt(bpmField.getText());
					if (Settings.setDefaultBPM(parsedBPM) == Settings.OUT_OF_RANGE) {
						statusBPM.setText("Valor invalido!");
					}
					else {
						statusBPM.setText("Salvo!");
					}
				}
				catch (NumberFormatException ex){
					statusBPM.setText("Valor deve ser inteiro!");
				}
				
				try {
					int parsedOctave = Integer.parseInt(dropDownOctaves.getSelectedItem().toString());
					if (Settings.setDefaultOctave(parsedOctave) == Settings.OUT_OF_RANGE) {
						statusOctave.setText("Valor invalido!");
					}
					else {
						statusOctave.setText("Salvo!");
					}
				}
				catch (NumberFormatException ex){
					statusOctave.setText("Valor deve ser inteiro!");
				}
				
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
		panel.add(saveButton);
		panel.add(statusVol);
		panel.add(statusBPM);
		panel.add(statusOctave);
	}
	
}
