/**
 * 
 */
package kottarath.assign3.topquiz.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;



/**
 * Main frame for Top Quiz application
 * @author Priya
 * 
 */
public class TopQuizFrame extends JFrame {

	//member components
	
	private JLabel lblTitle;
	
	
	private JButton btnStart;
	private JLabel lblError;
	
	private HeaderPanel headerPane;
	private SubjectPanel subjectPane;
	
	private QuizPanel quizPane;
	
	
	private Container contentPane;
	
	private String subjectChosen;
	
	/**
	 * Initialize values for first load
	 */
	private void initValues()
	{
		headerPane=null;
		subjectPane=null;
		quizPane=null;
		contentPane=null;
		subjectChosen=null;
		
	}

	/**
	 * Create the TopQuiz frame.
	 */
	public TopQuizFrame() {
		
		super("TOP QUIZ");
		
		initValues();
		//get content pane
		contentPane=getContentPane();
		contentPane.setBackground(new Color(255, 255, 255));
		
		//FRAME properties
		//set default size and minimum size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setSize(screenSize.width, screenSize.height);
    	setMinimumSize(new Dimension(800,500));
		//center the frame on screen
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		headerPane=new HeaderPanel();
		
		//set layout and add components
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(headerPane,BorderLayout.NORTH);
		createWelcomePanel();
		
		
	}
	
	/**
	 * Creates welcome panel
	 */
	private void createWelcomePanel()
	{
		JPanel welcomePane=new JPanel();
		welcomePane.setLayout(new GridLayout(0, 1));
				
		
		//topic selection panel
		subjectPane=new SubjectPanel();
		subjectPane.setSubjectListener(new SubjectListener() {
			
			@Override
			public void subjectChosen(String subject) {
				// update the subject chosen for quiz
				subjectChosen=subject;
				
			}
		});
		
		lblError=new JLabel("",SwingConstants.CENTER);
		
		//add start button
		JPanel startPane=new JPanel();
		btnStart=new JButton();
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setIcon(new ImageIcon("./Resources/LayoutImages/startbutton.png"));
		btnStart.setToolTipText("Start Playing");
		btnStart.setPreferredSize(new Dimension(100, 100));
		startPane.add(btnStart,Component.CENTER_ALIGNMENT);
		
		/**
		 * Start button click event
		 */
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Validate Subject selection
				if(subjectChosen!=null)
				{
					//ok, display QuizPanel, hide welcomePanel
					welcomePane.setVisible(false);
					
					//QUIZ PANEL
					
					quizPane=new QuizPanel(subjectChosen);
					quizPane.setVisible(true);
					
					
					contentPane.add(quizPane,BorderLayout.CENTER);//add quizPane to contentPane
				}
				else
				{
					//else, show error message
					lblError.setText("Please choose a topic to proceed.");//add lblError to layout
					lblError.setForeground(Color.RED);
				}
				
			}
		});
		
		
		
		welcomePane.add(subjectPane);
		welcomePane.add(startPane,Component.CENTER_ALIGNMENT);
		welcomePane.add(lblError);
		
		contentPane.add(welcomePane,BorderLayout.CENTER);//add to content pane
		
	}

}
