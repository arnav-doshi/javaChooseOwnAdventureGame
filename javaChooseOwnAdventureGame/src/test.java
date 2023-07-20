import java.util.*;
public class test
{
    public static void main (String[] args)
    {
        Initialize i = new Initialize();
        Enemy t = new Enemy("hello", "");
        Player p = new Player("playerplayer", "");
        ArrayList<Entity> welp = new ArrayList<Entity>();
        welp.add(t);
       // System.out.println("stats: " + p.getAllStats() + " maxHP: " + p.maxHP());
        p.addStat();
        //System.out.println("stats: " + p.getAllStats());
        p.addStat();
        System.out.println("player stats: " + p.getAllStats() + " maxHP: " + p.maxHP());
        System.out.println("Enemy stats: " + t.getAllStats() + " maxHP: " + t.maxHP());
        //System.out.println(check.displayText());
        //while(!welp.isEmpty() && !p.isDead())
        //{
            System.out.println(p.combatEnemy(welp, 1));
            //System.out.println("enemy hp: " + t.stats()[3]);
            //System.out.println("enemy att: " + t.stats()[0]);
            System.out.println( p.stats()[3] + "<-current hp ( hp check after return:) max hp->" + p.maxHP());
        //}
    }

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
