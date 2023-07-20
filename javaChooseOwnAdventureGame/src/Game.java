import java.util.*;

/**
 * Main game method
 */
public class Game
{
    private ArrayList<Entity> enemies;// in case we want more than one;
    private Entity            player;
//    private Story game;
    // private Story story;

    public Game()
    {
//        game = new Story();
        enemies = new ArrayList<Entity>();
        player = new Player("Player", "");
        Queue<String> entityNames = new LinkedList<String>();
        entityNames.add("dude1");
        entityNames.add("dude2");
        entityNames.add("dude3");
        entityNames.add("dude4");
        entityNames.add("dude5");
        Queue<String> enemySprites = new LinkedList<String>();
        enemySprites.add("");
        enemySprites.add("");
        enemySprites.add("");
        enemySprites.add("");
        enemySprites.add("");

        for (String s : entityNames)
        {
            enemies.add(new Enemy(entityNames.poll(), enemySprites.poll()));
        }


        // TODO open GUI
    }

    public void play()
    {
        while(true) //!game.isEnd()) -- >TODO This needs to be looking for variable playIsOn from MainWindow
        {
        	
            
        }
    }
    // ~Public Methods ........................................................

}
