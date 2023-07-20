
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.util.*;


@SuppressWarnings("serial")
public class MainWindow
    extends JFrame
    implements ActionListener
{
    private JButton      choiceA, choiceB;
    private JTextArea    scenario;
    private JPanel       basePanel, choices, player;
    private JLabel       health, healthNumber, weapon, weapoinType;

    private Story        game;
    boolean              playIsOn = false;
    private CombatWindow combat;
    private Player       user;
    private Initialize   enemyArray;
    private int          count    = 0;

    // constructor
    /**
     * MainWindow constructor to create Ash and initialize GUI
     */
    public MainWindow()
    {
        user = new Player(
            "Player1",
            "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK00OOko;,lkKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOxollccccc::::ccloxk0XNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0dl:;,,,,,,,,,,;;:::::;;:cox0NWMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKo:;'...............,::::::;;::okXWMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKl:;'..';::;,'.......';::::::;;:::o0WMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXd::;...;cllc:;,'''...';::::::;;::::l0WMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0l;:;...';:::,''......';:::::::;::::;dXMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWN0oldollccccc:,''......'::::::::;::::;l0WMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK00OOOOOkkkkkkkkkkkkxdlc::::::::::;:::::ckWMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKOkxxxxxxxxxxxxdc;,,;:oxOKXXKOxoc::::;::::::kWMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOxxxxxxxxxxxddc'.     ...;lx0XNNKOdl:;::::::ldxKWMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMN0kxdcclooollc,.          .:::::lxOko;',,,,,'..:0WMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0x,..';,,,'..,,.      .,::;;;coxd;.........'xNWMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKx;..':::;;,,;;.  ...,looooolldkko'.........;cldONMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWO;....'lxdccool:....,lxkkkkxdo::dkx;.............cXMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKc.....cxdool:cc;;ldxkkkk0Xo..,loxx:............,OWMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKc....;dxkk, .lxkkkkkkkk0Xd..,dxxk:.':ol'.....;OWMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMWNWMMMMMMMMMMMMMMMMMMMMMMMMWKc...:dk00c.,dkkkkkkkkkOKOc'lOOkkl:ldxx:.  .lKWMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMW0d0WMMMMMMMMMMMMMMMMMMMMMMMMWXl.'ldxO0klokOkkkkkkkkkO0kdkOkkkxddxkx;..;kNMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMWWXx:oXMMMMMMMMMMMMMMMMMMMMMMMMMMXc.;oxkxdxxkkxxxkkkkkkkxdddxkkkkxdxx:.,dXWMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MNOoolcckWMMMMMMMMMMMMMMMMMMMMMMMMWk,..,okxxxxkkkkkkkkkkkkkkxxkkkkxxdl,..lKWMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MXdc:cclkNMMMMMMMMMMMMMMMMMMMMMMMMW0dc;;lxkkkxxkO000KKXXXXKOxxkkkl,,'.   .'oKWMMMMMMMMMMMMMMMMMMMMMM\n"
                + "MNOlccokKXXNWMMMMMMMMMMMMMMMMMMMMMMMMWNX0OkxkxxkOXNWMMMWNKkxxkkx:. ..',;clokXWMMMMMMMMMMMMMMMMMMMMMM\n"
                + "0OdlccclllloONMMMMMMMMMMMMMMMMMMMMMMMMNK00OxddxxxkkO000OOkkkxxd;.  .lOXWWMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + ":;;:ccccccc:l0WMMMMMMMMMMMMMMMMMMMMMMMXkdoc::,;codxxxkkkxxdl;;:,'.',:kNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "l;;:cccccccccoKMMMMMMMMMMMMMMMMMMMMMMMW0xdl;;,''',;;coollcc;'''',;cdkXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "Ol:cc:::::cc::xNMMMMMMMMMMMMMMMMMMMMMMMXOxo:;;,'''',:cccclc:''';;:ox0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "Nkc:cc:ccclc::lOWMMMMMMMMMMMMMMMMMMMMMMWKkdl;;,',;;;cccccccc;',;:odkXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "W0olooccoolc:::oKWMMMMMMMMMMMMMMMMMMMWNKOddo:;,,:ccccccccccc;,;:ldloxk0XWWMMMMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "Kkxd:,;coolcc::cdXMMMMMMMMMMMMMMMMMMN0dollddc;:dkxdoollllllc;;:lollloloOXXNWWMMMMMMMMMMMMMMMMMMMMMMM\n"
                + "Xkkd;,coolc:::cclkWMMMMMMMMMMMMMMMWXkololcldl;l0NNNXXKOxddol;;loclooolo0WWNXXWMMMMMMMMMMMMMMMMMMMMMM\n"
                + "NOxdddxxxdc:cccccoKWMMMMMMMMMMMMWXX0dlooc;:do:xNMMMMMMWNXKOo:lo:;loooloONWMWXXWMMMMMMMMMMMMMMMMMMMMM\n"
                + "W0xkkxddddlccccccckNMMMMMMMMMMMWXXNOolol:;:oolOWMMMMMMMMMMXxoo:;:coooloxKWMMWXXWMMMMMMMMMMMMMMMMMMMM\n"
                + "MXOxkkxxdxdc,,lk00NWMMMMMMMMMMWXXNKdlol:;;;lodKWMMMMMMMMMWKxl:;;;cooollxXWMMMNKNMMMMMMMMMMMMMMMMMMMM\n"
                + "MMXOxkkxoodc''oXMMMMMMMMMMMMMWK0XXOoloc:;;;clxXWMMMMMMMMMNOl:;;;;cloolcdXMMMMWXKNMMMMMMMMMMMMMMMMMMM\n"
                + "MMMN0kkkxddo:;dNMMMMMMMMMMMMN0OKNXdlol:;;;cloONMMMMMMMMMMNkoc;;:;:loollOWMMMMMNOKWMMMMMMMMMMMMMMMMMM\n"
                + "MMMMWKkxkkkxolx0NWMMMMMMMMMNKKXWW0oloc;;;;cdd0WMMMMMMMMMMXkdc;::;:looldKMMMMMMWK0XWMMMMMMMMMMMMMMMMM\n"
                + "MMMMMWN0kkkkkkkkk0NWMMMMMWNKXNNXKkoll:;;;:lolx00000000000Oxo:;::;:lollxXMMMMWWWWXKNMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMWX0kkkkkkkxk0XWMMWKxdddk00dloc:;:;col;;::::::cccc::oo:;::;:collkNWNNNXXXXXKKNMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMWXOkkkkkkkkkOKNNklllcclolloc;:;;ldc;:::::::::::::oo:;::;;clllkNXK0OkxdooxONMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMWKkkkkkkkkkxkkxxkxdol:cll:;:;;lo:,:::::::::::::ol;;:::;:lllx0kollcclllxXMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMWN0kkkkkkkkkxddkkkxdc:cc:;:;:oo;;::::::::::::col:;:::;;:lool;;ldxxxxxONMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMWXOkkkkkkkkxdxkkkxo,..,;;;cdl:cccccccccccc:col:;::;:;;:cc;',dkkkkkkkKWMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMWKkkkkkkkkkkkxk0k,..';;;ldokKKKKKKKKKKKK0kdc;;:::::;'....,lxkkkkkxONMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMNKOkkkkkkkkkKNO'..';;:odd0WMMMMMMMMMMMNOdc;;:::::;,....':dkkkkkkkKWMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMNKOkxxxkOXWXl..',:;:odxKMMMMMMMMMMMMNOdc;;::::::;'...',cxkkkkkx0NMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMWNKKKXWMNx'.',;:;cddxXMMMMMMMMMMMMNOdl:;::::::;'....';okkkkkxONMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk,..,;:;;lddkNMMMMMMMMMMMMNOxl:;:::;;:;'.....,lkkkkkxkXMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWO;..,;;;;;oddkNMMMMMMMMMMMMN0xl:;:;;;;;;'.... .cxkkkkxkXWMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMNd,.,;:;;;:oddOWMMMMMMMMMMMMN0xo:;;;;:;:;,.... .:xkkkkkkKWMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWNOl;;:;;;:ddd0WMMMMMMMMMMMMN0xo:;;,;:::;,'''.. ,dkkkkkk0WMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0c;::;;;cdddKWMMMMMMMMMMMMW0xo:;;;;::::;;;:;'..lkkkkkx0WMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMXd:;:;;;;lddxXMMMMMMMMMMMMMWKxo:;;;;::::::;;;,..:xkkkkx0WMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMW0l;;:;;;:lddkXMMMMMMMMMMMMMWKxdc;;;;::::::::;;'.;dkkkkxONMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWk:;::;;,:oddkNMMMMMMMMMMMMMMKxdc;;;;::::::::;;,..lkkkkxONMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMNx;;::;;,:dxokNMMMMMMMMMMMMMMKxdl;;;;::::::;;:;,,cdkkkkxONMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMXd;;:;;;;:dxdONMMMMMMMMMMMMMMXkxl;;;;:::::;;;:;,:xkkkkkxkXWMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMKo;;;;;;;cdddkXNNWMMMMMWWNNNNKkxl;;;;;;;;;;;;;;,:dkkkkkkkXWMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMM0c;;;;;::cxdldO00KXXXXXXKKKKKOxxo:;:;;;;;;:::;;;;lkkkkkxkXWMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMN0kl,'''',::,,;;;;;;;;;;;;;;;;:c;,',,,,,,,,'',codkkkkkkxkKWMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk,.......'',,,,,,''''',,,,,''..............lO0Okkkkkkk0WMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk;','',,,,,,,,,,,,'''',,,,,,,'''''''''''...'oxkkkkkkkxONMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNd,',,,,,,,,,,,,,,,'''',,,,,,,,,,,,,,,,,,'...lkkkkkkkkxkXMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0c',,,,,,,,,,,,,,,,''',,,,,,,,,,,,,,,,,,,,...cxxddkkkkkkKWMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM0;',,,,,,,,,,,,,,,,''',,,,,,,,,,,,,,,,,,,,'..lxdoodkkxxkXWMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWO;',,,,,,,,,,,,,,,,''',,,,,,,,,,,,,,,,,,,,'..,cododkxoxKWMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWk;',,,,,,,,,,''',,,'''',,,,,,,,,,,,,,,,,,,,'...cxxxxdx0WMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMNd,',,,,,,,,,,,''''''''',,,,,,,,,,,,,,,,,,,,'...c0XKKKXWMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMXo,',,,,,,,,,,,,,''''''',,,,,,,,,,,,,,,,,,,,,'..'xWMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMXl'',,,,,,,,,,,,,,,''...',,,,,,,,,,,,,,,,,,,,'...lXMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMKc,',,,,,,,,,,,,,,,,'...;;'',,,,,,,,,,,,,,,,,'...,OWMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWO:',,,,,,,,,,,,,,,,,'..,k0l,',,,,,,,,,,,,,,,,,'...lXMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWk,',,,,,,,,,,,,,,,,,'..;0W0:',,,,,,,,,,,,,,,,,'...;0MMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMWx'',,,,,,,,,,,,,,,,,'..cKMNo',,,,,,,,,,,,,,,,,,'...oNMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMNd'',,,,,,,,,,,,,,,,,'..oNMWk;',,,,,,,,,,,,,,,,,'...:KMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMXo,',,,,,,,,,,,,,,,,,'.'dWMMKl'',,,,,,,,,,,,,,,,'...'xWMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMKl,,,,,,,,,,,,,,,,,,,'.'dNMMNd,',,,,,,,,,,,,,,,,,'...cXMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMM0c',,,,,,,,,,,,,,,,,,'.'oXMMMO:',,,,,,,,,,,,,,,,,'...,OWMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMM0:',,,,,,,,,,,,,,,,,,'',lKMMMXo,',,,,,,,,,,,,,,,,,'...oNMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMM0:',,,,,,,,,,,,,,,,,,,''c0MMMWx,',,,,,,,,,,,,,,,,,'...oNMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMXd:,'''',,,,,,,,,,''',,,oKMMMMKl,,''''',,,,,,,,,,,;:lONMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWX0kdoc;,,,,,,,,;ldxOO0NWMMMMWX0Okxxddl;;,,,;;;;lONWMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXxcccccccclONMMMMMMMMMMMMMMMMMMWXxccccccccdXMMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKxxxxxddxdkXWMMMMMMMMMMMMMMMMMMW0ddddddxdxKWMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOxkkkkkkkx0WMMMMMMMMMMMMMMMMMMWKkkkkkkkkxONMMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0kkkkkkkkxOXMMMMMMMMMMMMMMMMMMWKkxkkkkkkkkKWMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKkkkkkkkkkkKWMMMMMMMMMMMMMMMMMMXkxkkkkkkkxONMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkxkkkkkkkxONMMMMMMMMMMMMMMMMMMNkxkkkkkkkkkXMMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXOxkkkkkkkxkXWWMMMMMMMMMMMMMMMMNOxkkkkkkkkx0WMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOxkkkkkkkkkKNWMMMMMMMMMMMMMMMMWKkkkkkkkkkxONMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0xkkkkkkkkk0NWMMMMMMMMMMMMMMMMMNOxkkkkkkkkkXMMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMKxkkkkkkkxkKNWMMMMMMMMMMMMMMMMMWKkxkkkkkkkkKWMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkkkkkkkkxkXWWMMMMMMMMMMMMMMMMMMW0kkkkkkkkx0NMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkkkkkkkkxkNMMMMMMMMMMMMMMMMMMMMMNOxkkkkkkxkXMMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkkkkkkkkxONMMMMMMMMMMMMMMMMMMMMMWKkxkkkkkkkKWMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXOkkkkkkkx0NMMMMMMMMMMMMMMMMMMMMMMW0xkkkkkkx0WMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXOkkkkkkxxKWMMMMMMMMMMMMMMMMMMMMMMMNOxkkkkkxONMMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkkkkkkkxkKWMMMMMMMMMMMMMMMMMMMMMMMWKkkkkkkkkKWMMMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNKOOxodxkkkkkoxXWWMMMMMMMMMMMMMMMMMMMMMW0xxkxdooldOXWMMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWOc'.....':dkkd;.o0XMMMMMMMMMMMMMMMMMMMMWk;,:;,......,oXMMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXd,...',:cccc:'..:dKMMMMMMMMMMMMMMMMMMMMWx..,;'......'l0WMMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXdlxdlool:,.......;lkWMMMMMMMMMMMMMMMMMMMWx'.,loolc:,:doo0MMMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXkllodOd,...,,,,,;;;:l0MMMMMMMMMMMMMMMMMMMNo,,....,:dO0OdldKWMMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMWNKko:;'..,dl..,:::::;:;,:xNMMMMMMMMMMMMMMMMMWKl;:;,...,do;';clx0WMMMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMMMWXK0koc:,.......';'.';;:::;;;;cd0WMMMMMMMMMMMMMMMMWOc;::;..;dc.......,dKWMMMMMM\n"
                + "MMMMMMMMMMMMMMMMMMMWkc,'...'','''..........,;;:cokOOkxKWMMMMMMMMMMMMMMMNOo:;;,......'',,,,,,:xXWMMMM\n"
                + "MMMMMMMMMMMMMMMMMMWk,.......................:dOKXK0Oxd0WMMMMMMMMMMMMMMWXXXOl;.......',;;;;;;,';oOXWM\n"
                + "MMMMMMMMMMMMMMMMMMNOo:,..................,lkKNWXOxxxk0NMMMMMMMMMMMMMMMWXKNWXk:...................,oK\n"
                + "MMMMMMMMMMMMMMMMMMWXXXK0kdllc:;,'''';:ldOXXXXXK00KXNWMMMMMMMMMMMMMMMMMMWNXXNNKl....................c\n"
                + "MMMMMMMMMMMMMMMMMMMWNXXXXXNNNXKKKKKKXXNNXXXNMWWMMMMMMMMMMMMMMMMMMMMMMMMMMWNNKKKx;.................'c\n"
                + "MMMMMMMMMMMMMMMMMMMMMMWWWNNNNXXXXXXXXXNNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXKXKxl:,'''''',,;clxOK0\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXXXXKKK000KKXNNNNXXX\n"
                + "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXKKXXKKKKXXXKKXXNW");
        game = new Story();
        enemyArray = new Initialize();
        initUI();
        playIsOn = true;
    }


    private void initUI()
    {

        basePanel = new JPanel();
        // basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        basePanel.setBackground(Color.black);
        basePanel.setBounds(100, 100, 600, 250);

        // scenario panel
        scenario = new JTextArea("asaaa");
        scenario.setBounds(100, 100, 600, 250);
        scenario.setBackground(Color.black);
        scenario.setForeground(Color.white);
        scenario.setFont(new Font("Courier New", Font.BOLD, 22));
        scenario.setLineWrap(true);
        basePanel.add(scenario);

        // Choices panel and buttons
        choices = new JPanel();
        choices.setBounds(100, 350, 600, 150);
        choices.setBackground(Color.black);
        choices.setLayout(new GridLayout(2, 1));

        choiceA = new JButton("choiceA");
        choiceA.setBackground(Color.black);
        choiceA.setForeground(Color.blue);
        choiceA.setFont(new Font("Courier New", Font.BOLD, 20));
        choiceA.addActionListener(this);
        choiceA.setActionCommand("c1");
        choices.add(choiceA);

        choiceB = new JButton("choiceB");
        choiceB.setBackground(Color.black);
        choiceB.setForeground(Color.blue);
        choiceB.setFont(new Font("Courier New", Font.BOLD, 20));
        choiceB.addActionListener(this);
        choiceB.setActionCommand("c2");
        choices.add(choiceB);

        // player health and weapon panel
        player = new JPanel();
        player.setBounds(100, 15, 600, 50);
        player.setBackground(Color.blue);
        player.setLayout(new GridLayout(1, 4));

        health = new JLabel("Health");
        health.setFont(new Font("Courier New", Font.BOLD, 20));
        health.setForeground(Color.white);
        player.add(health);

        healthNumber = new JLabel();
        healthNumber.setFont(new Font("Courier New", Font.BOLD, 20));
        healthNumber.setForeground(Color.white);
        player.add(healthNumber);

        weapon = new JLabel("Weapon");
        weapon.setFont(new Font("Courier New", Font.BOLD, 20));
        weapon.setForeground(Color.white);
        player.add(weapon);

        weapoinType = new JLabel();
        weapoinType.setFont(new Font("Courier New", Font.BOLD, 20));
        weapoinType.setForeground(Color.white);
        player.add(weapoinType);

        //add(player);
        add(basePanel);
        add(choices);

        /* demo method calls */

        setPlayer("0", "");
        setScenario("Your are at dungeon gate \n\n what you will do");
        setChoices("Run Away fast", "Fight Back");

    }

    /// set player score


    /**
     * setPlayer that sets the healthNumber and weaponType in text in GUI
     * @param healthNum the number of health that they player has
     * @param weaponType the weapon that the player has 
     */
    public void setPlayer(String healthNum, String weaponType)

    {
        healthNumber.setText(healthNum);
        weapoinType.setText(weaponType);

    }


    /// set scenario
    /**
     * A method that sets the node to the scenario in text. Pretty vital
     * @param scenarioText the text to pass into the scenario
     */
    public void setScenario(String scenarioText)
    {
        scenario.setText(game.getCurrentNodeData());

    }


    /// set choices
    /**
     * The choices to set as the texts in the buttons. Can either be the next node or just "Choice A" or "Choice B"
     * @param choiceAtext the text to pass into the first button
     * @param choiceBtext the text to pass into the second button
     */
    public void setChoices(String choiceAtext, String choiceBtext)
    {
//        choiceA.setText(game.getCurrentChoiceA());
//        choiceB.setText(game.getCurrentChoiceB());
        choiceA.setText("Choice A");
        choiceB.setText("Choice B");

    }


    // button event handler
    /**
     * Logic behind the game and the actions performed. It sets the current nodes as the left or right one.
     * @param Actionevent e is the event that the user inputs
     */
    public void actionPerformed(ActionEvent e)
    {
        String b = e.getActionCommand();

        if (b.equals("c1"))
        {
            // add your logic here and set next scenario , player score and next
            // choices
            //System.out.println("Button A Press");
            game.setCurrentNode(game.getCurrentNodeLeft());
            if (game.isTerminatingNode())
            {
                playIsOn = false;
                dispose(); 
                GameOver g = new GameOver(game.getCurrentNodeData());
                //System.out.println( game.getCurrentNodeData()); 
                //g.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                g.setBounds( 100, 100, 1200, 600);    
                g.getContentPane().setBackground(Color.red);
                g.setLayout(null);
                g.setVisible(true);
                //setVisible(false);
                combat.setVisible(false);
            }
            else
            {
                combat();
            }

        }
        else if (b.equals("c2"))

        {
            // add your logic here and set next scenario , player score and next
            // choices
            //System.out.println("Button B Press");
            game.setCurrentNode(game.getCurrentNodeRight());
            if (game.isTerminatingNode())
            {
                playIsOn = false;
                dispose(); 
                GameOver g = new GameOver(game.getCurrentNodeData());
                //System.out.println( game.getCurrentNodeData()); 
                //g.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                g.setBounds( 100, 100, 1200, 600);    
                g.getContentPane().setBackground(Color.red);
                g.setLayout(null);
                g.setVisible(true);
                //setVisible(false);
                combat.setVisible(false);
            }
            else
            {
                combat();
            }
        }
        if (playIsOn) {
            setChoices(null, null);
            setScenario(null);
        }
        if (count < enemyArray.getEnemies().size() - 1)
        {
            count += 1;
        }
        //user.equipItem(new Loot(count));
    }

    /**
     * Performs all necessary calls and initializations for combat
     */
    public void combat()
    {
        ArrayList<Entity> c = new ArrayList<Entity>();
        for (Entity enemy : enemyArray.getEnemies())
        {
            enemy.heal();
        }
        c.add(enemyArray.getEnemies().get(count));
        combat = new CombatWindow(user, c, count);
        //combat.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        combat.setBounds( 100, 100, 800, 1000);    
        combat.getContentPane().setBackground(Color.black);
        combat.setLayout(null);
        combat.setVisible(true);   
        for (Entity en : enemyArray.getEnemies())
        {
            en.addStat();
        }
        user.addStat();
        //System.out.println("stat increment");
    }

}
