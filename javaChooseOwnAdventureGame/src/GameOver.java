import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GameOver extends JFrame {

    private JPanel titlePanel;
    private JTextArea titleText; 
//    private Font titleFont= new Font ("Time New Roman",Font.PLAIN,50);

  //constructor
  /**
   * GameOver constructor to see what outcome it is and call the respective method
 * @param lastGameState the string containing what the last line was before the story ended
 */
public GameOver(String lastGameState) 
  {
	if (lastGameState.contains(" die")) {
		initUIGameOver(lastGameState);
	} else if (lastGameState.contains(" end")){
		initUIGameWin(lastGameState);
	} else {
		initUIGameOver(lastGameState);
	}
    
  }

   
  private void initUIGameOver(String str) 
  {
      titlePanel=new JPanel();
      titlePanel.setBounds(100, 100, 1000, 600);
      titlePanel.setBackground(Color.red);
      
      System.out.println(str);
   
      /*
      titleLabel=new JLabel(str);
      titleLabel.setForeground(Color.blue);
      titleLabel.setFont(new Font("Courier New", Font.BOLD, 15));
      titlePanel.add(titleLabel);
      add(titlePanel);
      */ 
      
      titleText = new JTextArea( str ); 
      titleText.setBounds(100, 100, 1000, 600);
      titleText.setBackground( Color.red );
      titleText.setForeground( Color.white );
      titleText.setFont( new Font("Courier New", Font.BOLD, 35));
      titleText.setLineWrap( true );
      titleText.setWrapStyleWord(true);
      
      /*textScroll=new JScrollPane();
      textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      textScroll.setBounds(100, 100, 1200, 600);
      textScroll.add(titleText);*/
      
      titlePanel.add(titleText);
      add(titlePanel);
  }
  
  private void initUIGameWin(String str) {
	 titlePanel=new JPanel();
      titlePanel.setBounds(100, 100, 1500, 2000);
      titlePanel.setBackground(Color.green);
      
      System.out.println(str);
      
      titleText = new JTextArea( str ); 
      titleText.setBounds(100, 100, 1000, 1500);
      titleText.setBackground( Color.green );
      titleText.setForeground( Color.black );
      titleText.setFont( new Font("Courier New", Font.BOLD, 35));
      titleText.setLineWrap( true );
      titleText.setWrapStyleWord(true);

      titlePanel.add(titleText);
      add(titlePanel);
  }

}