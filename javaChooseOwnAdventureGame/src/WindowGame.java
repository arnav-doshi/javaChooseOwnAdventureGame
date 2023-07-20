import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

public class WindowGame extends JFrame implements ActionListener
{

    private JButton start; 
    
       
    private JPanel titlePanel;
    private JLabel titleLabel;   
    private Font titleFont= new Font ("Time New Roman",Font.PLAIN,50);
    private JPanel startePanel;
    
    
  //constructor
   public WindowGame() 
   {
    initUI();
    }
   
   private void initUI() 
    {
	   titlePanel=new JPanel();
	   titlePanel.setBounds(100,100,600,150);
	   titlePanel.setBackground(Color.black);
	   
	   titleLabel=new JLabel("Hero of Fulk");
	   titleLabel.setForeground(Color.white);
	   titleLabel.setFont(titleFont);
	   
	   startePanel=new JPanel();
	   startePanel.setBounds(300,400,200,100);
	   startePanel.setBackground(Color.black);	   
	   
	   start = new JButton("START");
	   start.setBackground(Color.black);
	   start.setForeground(Color.blue);
	   start.setFont(new Font("Courier New", Font.BOLD, 30));
	  
	   
	   start.addActionListener(this);
	   titlePanel.add(titleLabel);
	   startePanel.add(start);
	   add(titlePanel);
	   add(startePanel);
	   
	
   }
   
   
   //event handler for start button
  public void actionPerformed( ActionEvent e )
  {
      //AbstractButton b = (AbstractButton)e.getSource(); 
//      System.out.print( "B" );
      dispose(); 
      
      MainWindow window = new MainWindow();       
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setBounds( 100, 100, 800, 600);    
      window.getContentPane().setBackground(Color.black);
      window.setLayout(null);
	  window.setVisible(true); 	  
     
  }
}
