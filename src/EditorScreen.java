import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditorScreen extends Screen {
	
	public EditorScreen(ScreenManager screenManager) throws IOException {
		super(screenManager);
		panel.setBackground(Color.BLACK);
		Image pauseImage = ImageIO.read(getClass().getResource("resources/pause-button.png"));
		Image playImage = ImageIO.read(getClass().getResource("resources/play-button.png"));
		Image stopImage = ImageIO.read(getClass().getResource("resources/stop-button.png"));
		Image settingsImage = ImageIO.read(getClass().getResource("resources/settings-button.png"));
		Image importImage = ImageIO.read(getClass().getResource("resources/import-button.png"));
		JFileChooser fc = new JFileChooser();

		ImageIcon tableImage1 = new ImageIcon("src/resources/table1.png");
		ImageIcon tableImage2 = new ImageIcon("src/resources/table2.png");
		
		JButton playButton = new JButton();
		JButton stopButton = new JButton();
		JButton navButton = new JButton();
		JButton importButton = new JButton();
		JButton saveButton = new JButton("Salvar midi");
		JTextArea textArea = new JTextArea("Digite aqui seu texto...");
		JLabel commandTable1 = new JLabel();
		JLabel commandTable2 = new JLabel();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		commandTable1.setIcon(tableImage1);
		commandTable2.setIcon(tableImage2);
		
		playButton.setBounds(500, 500, 50, 50);
		stopButton.setBounds(560, 500, 50, 50);
		saveButton.setBounds(100, 500, 150, 50);
		navButton.setBounds(10, 10, 50, 50);
		importButton.setBounds(640, 95, 40, 40);
		scroll.setBounds(30, 140, 650, 300);
		commandTable1.setBounds(690, 40, 250, 500);
		commandTable2.setBounds(910, 40, 350, 500);
		
		textArea.setLineWrap(true);
		
		Icon pauseIcon = ScreenManager.resizeIcon(pauseImage, playButton);
		Icon playIcon = ScreenManager.resizeIcon(playImage, playButton);
		Icon stopIcon = ScreenManager.resizeIcon(stopImage, stopButton);
		Icon settingsIcon = ScreenManager.resizeIcon(settingsImage, navButton);
		Icon importIcon = ScreenManager.resizeIcon(importImage, importButton);
		playButton.setIcon(playIcon);
		stopButton.setIcon(stopIcon);
		navButton.setIcon(settingsIcon);
		importButton.setIcon(importIcon);
		
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MusicPlayer.isStopped()) {
					System.out.println("Tocando a m�sica " + textArea.getText());
					playButton.setIcon(pauseIcon);
					MusicPlayer.Play();
				}
				else if (MusicPlayer.isPaused()) {
					playButton.setIcon(pauseIcon);
					MusicPlayer.Resume();
				}
				else if(MusicPlayer.isPlaying()) {
					System.out.println("Musica Pausada");
					playButton.setIcon(playIcon);
					MusicPlayer.Pause();
				}
			}
		});
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop!");
				playButton.setIcon(playIcon);
				MusicPlayer.Stop();
			}
			
		});
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusicRecorder.recordMusic();
				System.out.println("Criado arquivo");
			}
			
		});
		navButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Foi para Settings");
				screenManager.changeScreen(screenManager.getSettingsScreen());
			}
			
		});
		
		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Importou");
				int result = fc.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File input = fc.getSelectedFile();
					String stringData;
					try {
						stringData = Files.lines(input.toPath(), StandardCharsets.UTF_8).collect(Collectors.joining("\n"));
						textArea.setText(stringData);
						System.out.println(stringData);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				sendTextUpdate(textArea.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				sendTextUpdate(textArea.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) { sendTextUpdate(textArea.getText()); }
			
		});

		panel.add(playButton);
		panel.add(stopButton);
		panel.add(saveButton);
		panel.add(navButton);
		panel.add(importButton);
		panel.add(scroll);
		panel.add(commandTable1);
		panel.add(commandTable2);
	}

	private void sendTextUpdate(String text){
		Reader.setMusicString(text);
	}
}
