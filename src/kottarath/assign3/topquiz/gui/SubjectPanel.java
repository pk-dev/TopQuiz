/**
 * 
 */
package kottarath.assign3.topquiz.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Topic selection panel
 * 
 * @author Priya
 * 
 */
public class SubjectPanel extends JPanel {

	//member controls
	private JLabel lblMessage;
	private JRadioButton rdoGeography;
	private JRadioButton rdoScience;
	private JRadioButton rdoEntertainment;
	private ButtonGroup rdoGrpSubject;
	
	
	private RadioButtonEventHandler rdoBtnEventHandler;
	private SubjectListener subjectListener;
	
	
	public final String FILE_PATH="./Resources/LayoutImages/";//folder path where style images are located.
	
	//setter
	public void setSubjectListener(SubjectListener subjectListener) {
		this.subjectListener = subjectListener;
	}
	
	
	/**
	 * Create Subject panel.
	 */
	public SubjectPanel() {
		
		rdoBtnEventHandler=new RadioButtonEventHandler();
		
		
		rdoGeography=new JRadioButton("Geography");
		rdoGeography.setForeground(new Color(0, 0, 128));
		rdoGeography.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		rdoGeography.setActionCommand("Geography");
		rdoGeography.addActionListener(rdoBtnEventHandler);
		
		rdoScience = new JRadioButton("Science");
		rdoScience.setForeground(new Color(0, 0, 128));
		rdoScience.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		rdoScience.setActionCommand("Science");
		rdoScience.addActionListener(rdoBtnEventHandler);
		
		rdoEntertainment=new JRadioButton("Entertainment");
		rdoEntertainment.setForeground(new Color(0, 0, 128));
		rdoEntertainment.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		rdoEntertainment.setActionCommand("Entertainment");
		rdoEntertainment.addActionListener(rdoBtnEventHandler);
		
		rdoGrpSubject=new ButtonGroup();
		rdoGrpSubject.add(rdoGeography);
		rdoGrpSubject.add(rdoScience);
		rdoGrpSubject.add(rdoEntertainment);
		
		//prompt for topic selection
		JLabel lblWelcome=new JLabel("<html>Choose a Topic<br/></html>",SwingConstants.LEFT);
		lblWelcome.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		
		//add controls to panel
		
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(220,310));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(JComponent.TOP_ALIGNMENT);
		
		
		panel.add(lblWelcome);
		panel.add(new JLabel("<html><br/></html>"));
		panel.add(rdoGeography);
		panel.add(rdoScience);
		panel.add(rdoEntertainment);
		
		
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        add(panel,gbc);//add to layout
		
        
       
	}
	
	/**
	 * Selects requested topic
	 * @param subject
	 */
	public SubjectPanel(String subject)
	{
		this();
		switch(subject)
		{
		case "Geography":rdoGeography.setSelected(true);
			break;
		case "Science":rdoScience.setSelected(true);
			break;
		case "Entertainment":rdoEntertainment.setSelected(true);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Event handler for topic radio buttons
	 * @author Priya
	 *
	 */
	 class RadioButtonEventHandler implements ActionListener
	   {  
	      public void actionPerformed(ActionEvent event)
	      {  
	    	  
	    	  JRadioButton rdo=(JRadioButton)event.getSource();
	    	  
	    	 //invoke subjectChosen method to update the topic chosen for quiz
	    	  subjectListener.subjectChosen(rdo.getActionCommand());
	          
	    	  
	      }
	   }


	

}
