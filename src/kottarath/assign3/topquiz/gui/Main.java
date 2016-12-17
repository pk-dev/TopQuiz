/**
 * GUI files
 */
package kottarath.assign3.topquiz.gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Main Thread
 * @author Priya
 * 
 */
public class Main {

	/**
	 * runs the application as a thread
	 * @param args
	 */
	public static void main(String[] args) {
		//runs the application as the event dispatch thread
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {//look and feel made cross platform
				    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
				 } catch (Exception e) {
				            e.printStackTrace();
				 }
				
				new TopQuizFrame();//call the main frame
			}
		});

	}

}
