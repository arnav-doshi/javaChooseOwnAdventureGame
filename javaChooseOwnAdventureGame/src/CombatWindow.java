import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Font.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.AbstractButton;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 *  Window that pops up for combat
 */
public class CombatWindow extends JFrame implements ActionListener {

    private JButton attackButton, evadeButton, blockButton, potionButton;
    private JTextArea scene, character, entity;
    private JPanel basePanel, topPanel, choice, player;
    private JLabel health, healthNumber;
    private Player user;
    private ArrayList<Entity> enemies;
    private int scalar;

    //constructor
    /**
     * Create a new CombatWindow object.
     * @param p player obj
     * @param e enemy arraylist
     */
    public CombatWindow(Player p, ArrayList<Entity> e, int count)
    {
        user = p;
        enemies = e;
        scalar = count;
        initUI();

    }

    private void initUI() {

        basePanel = new JPanel();
        //basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        basePanel.setBackground(Color.black);
        basePanel.setBounds(100,100,600,250);

        //scene panel
        scene=new JTextArea("You've ecountered " + enemies.get(0).getName());
        scene.setBounds(100,100,600,250);
        scene.setBackground(Color.black);
        scene.setForeground(Color.white);
        scene.setFont(new Font("Courier New", Font.BOLD, 18));
        scene.setLineWrap(true);
        basePanel.add(scene);


        //character and entity ascii image

        topPanel = new JPanel();
        //basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.black);
        topPanel.setBounds(100,400,600,500);


        character=new JTextArea(user.getSprite());
        character.setBounds(100,400,350,450);
        character.setBackground(Color.black);
        character.setForeground(Color.white);
        character.setFont(new Font("monospaced", Font.BOLD, 3));
        //character.setLineWrap(true);
        topPanel.add(character);

        entity=new JTextArea(enemies.get(0).getSprite());
        entity.setBounds(500,400,350,450);
        entity.setBackground(Color.black);
        entity.setForeground(Color.white);
        entity.setFont(new Font("monospaced", Font.BOLD, 3));
        //entity.setLineWrap(true);
        topPanel.add(entity);

        //choice panel and button
        choice = new JPanel();
        choice.setBounds(250, 900, 320, 160);
        choice.setBackground(Color.black);
        choice.setLayout(new GridLayout(2,1));

        attackButton=new JButton("Attack");
        attackButton.setForeground(Color.red);
        attackButton.setFont(new Font("Courier New", Font.BOLD, 20));
        attackButton.addActionListener(this);
        attackButton.setActionCommand("Attack");

        evadeButton=new JButton("Evade");
        evadeButton.setForeground(Color.green);
        evadeButton.setFont(new Font("Courier New", Font.BOLD, 20));
        evadeButton.addActionListener(this);
        evadeButton.setActionCommand("Evade");

        blockButton=new JButton("Block");
        blockButton.setForeground(Color.blue);
        blockButton.setFont(new Font("Courier New", Font.BOLD, 20));
        blockButton.addActionListener(this);
        blockButton.setActionCommand("Block");

        potionButton=new JButton("Heal");
        potionButton.setForeground(Color.pink);
        potionButton.setFont(new Font("Courier New", Font.BOLD, 20));
        potionButton.addActionListener(this);
        potionButton.setActionCommand("Heal");
        //attackButton.setBackground(Color.black);
        //choiceA.addActionListener(this);
        //choiceA.setActionCommand("c1");
        choice.add(attackButton);
        choice.add(evadeButton);
        choice.add(blockButton);
        choice.add(potionButton);






        //player health
        player=new JPanel();
        player.setBounds(100,15,600,50);
        player.setBackground(Color.blue);
        player.setLayout(new GridLayout(1,4));

        health=new JLabel("Health");
        health.setFont(new Font("Courier New", Font.BOLD, 20));
        health.setForeground(Color.white);
        player.add(health);

        healthNumber=new JLabel();
        healthNumber.setFont(new Font("Courier New", Font.BOLD, 20));
        healthNumber.setForeground(Color.white);
        player.add(healthNumber);



        add(player);
        add(basePanel);
        add(topPanel);
        add(choice);

       /* demo method calls*/

       //setPlayer("20");
        //setScene("Enemy is attacking you, use your power and attack back");

    }

    ///set scene
    /**
     * @param sceneText
     */
    public void setScene(String sceneText)
    {
        scene.setText(sceneText);

    }

    /**
     * set player score
     */
    public void setPlayer()

    {
        healthNumber.setText(user.stats()[3] + " / " + user.maxHP());

    }



    //button event handler
    public void actionPerformed( ActionEvent e )
    {
        int result = 0;
        choice.setVisible(false);
        String c = e.getActionCommand();
        if (c.equals("Attack"))
        {
            setPlayer();
            result = user.combatEnemy(enemies, 1);
            if (!enemies.get(0).isDead())
            {
                scene.setText("You've been hit for " + (user.maxHP() - user.stats()[3]) + '\n' +
                    "You hit " + enemies.get(0).getName() + " for " + (user.stats()[0] - enemies.get(0).stats()[1])
                    + '\n' + enemies.get(0).getName() + " has " + enemies.get(0).stats()[3] + " hp remaining");
            }
            else
            {
                Loot item = new weapon(scalar);
                scene.setText("You've been hit for " + (user.maxHP() - user.stats()[3]) + '\n' +
                    "You hit " + enemies.get(0).getName() + " for " + (user.stats()[0] - enemies.get(0).stats()[1])
                    + '\n' + enemies.get(0).getName() + " has " + enemies.get(0).stats()[3] + " hp remaining"
                    + '\n' + enemies.get(0).getName() + " has died"
                + "You got a weapon! Stat comparison: " + user.compareLoot(item));
                user.equipItem(item);
            }
            setPlayer();
        }
        else if (c.equals("Evade"))
        {
            setPlayer();
            result = user.combatEnemy(enemies, 2);
            scene.setText("You've been hit for " + (user.maxHP() - user.stats()[3]) );
            setPlayer();
        }
        else if (c.equals("Block"))
        {
            setPlayer();
            result = user.combatEnemy(enemies, 3);
            scene.setText("You've been hit for " + (user.maxHP() - user.stats()[3]) );
            setPlayer();
        }
        else if (c.equals("Heal"))
        {
            setPlayer();
            result = user.combatEnemy(enemies, 0);
            scene.setText("You've been hit for " + (user.maxHP() - user.stats()[3]) + '\n' +
                "You healed for " + user.maxHP() / 2 + '\n' + "You have " + user.stats()[3] + " hp");
            setPlayer();
        }
        if(result == 0)
        {
            choice.setVisible(true);
        }
        else if (result == -1)
        {
            this.setVisible(false);
            System.out.println("bug?");
            GameOver g = new GameOver("Game Over");
            g.setVisible(true);
        }

     }

}
