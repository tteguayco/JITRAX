package es.ull.etsii.jitrax.gui.dialogs;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ErrorsDialog extends JFrame {
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private static final int PADDING_TOP = 5;
	private static final int PADDING_LEFT = 15;
	private static final int PADDING_BOTTOM = 5;
	private static final int PADDING_RIGHT = 15;
	
	private static final String WINDOW_TITLE = "Errors";
	private static final String MESSAGE = "The system detected the "
			+ "following errors:";
	
	private JButton okButton;
	private JTextArea errorsTextArea;
	
	public ErrorsDialog(ArrayList<String> errors) {
		okButton = new JButton("Ok");
		errorsTextArea = new JTextArea();
		
		setLayout(new BorderLayout());
		okButton.addActionListener(new OkButtonListener());
		errorsTextArea.setEditable(false);
		
		// Showing errors
		for (int i = 0; i < errors.size(); i++) {
			errorsTextArea.append(" - " + errors.get(i) + "\n");
		}
		
		JPanel mainContainer = new JPanel(new BorderLayout());
		JPanel messagePanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		messagePanel.add(new JLabel(MESSAGE));
		JScrollPane errorsPanelSP = new JScrollPane(errorsTextArea);
		errorsPanelSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		errorsPanelSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		mainContainer.setBorder(BorderFactory.createEmptyBorder(PADDING_TOP, 
				PADDING_LEFT, PADDING_BOTTOM, PADDING_RIGHT));
		
		buttonsPanel.add(okButton);
		mainContainer.add(messagePanel, BorderLayout.NORTH);
		mainContainer.add(errorsPanelSP, BorderLayout.CENTER);
		mainContainer.add(buttonsPanel, BorderLayout.SOUTH);
		
		add(mainContainer);
		buildWindow();
	}
	
	private void buildWindow() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class OkButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			ErrorsDialog.this.dispose();	
		}
	}
}
