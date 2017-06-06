package es.ull.etsii.jitrax.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class AboutWindow {
	private static final int WINDOW_WIDTH = 300;
	private static final int WINDOW_HEIGHT = 300;
	private static final int IMAGE_WIDTH = 100;
	private static final int IMAGE_HEIGHT = 100;
	
	private static final String PATH_TO_IMAGE = "img/cusl.png";
	private static final String WINDOW_TITLE = "About JITRAX";
	private static final String MESSAGE = "<html><body width='" + String.valueOf(400)
			+ "'><h2>JITRAX: Java Interpretation Tool for"
			+ " Relational Algebra Expressions</h2>"
			+ "<p>JITRAX has been developed as an end-of-degree project"
			+ " by Teguayco Gutiérrez González under the supervision of Jesús M. Jorge Santiso"
			+ " at La Laguna University."
			+ "<br><br>It has also won the Best Educational Project award at the 11th University "
			+ "Competition of Free Software held in Seville, Spain."
			+ "</p>";
	
	public AboutWindow() {
		UIManager.put("OptionPane.okButtonText", "OK");
		showMessageDialog();
	}
	
	public void showMessageDialog() {
		JOptionPane.showMessageDialog(
                null,
                MESSAGE,
                WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE,
                getImageResized());
	}
	
	private static ImageIcon getImageResized() {
		ImageIcon imageIcon = new ImageIcon(PATH_TO_IMAGE);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);  
		imageIcon = new ImageIcon(newimg);
		
		return imageIcon;
	}
	
	public static void main(String args[]) {
		AboutWindow aboutWindow = new AboutWindow();
	}
}
