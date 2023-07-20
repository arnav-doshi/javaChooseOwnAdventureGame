import java.util.*;

/**
 * Entity class with stats, name, combat methods, sprite, stat modifier methods
 */
public class Entity
{
    private String                       name;
    private static CombatComparator      turn        = new CombatComparator();
    private PriorityQueue<Entity> order ; //(5 is arbritrary, change if needed)
    private ArrayList<Entity>         waitingRoom; // exists so no infinite turn looping and if players goes last
    private int[]                        stats; // att def spd hp in that order
    private String sprite;
    private int healthCap;

    /**
     * Create a new Entity object.
     *
     * @param n
     *            name
     * @param img sprite for GUI
     */
    public Entity(String n , String img)
    {
        sprite = img;
        name = n;
        if (this instanceof Player)
        { // player default stats
            int[] init = { 2, 4, 2, 5 };
            stats = init;
            healthCap = stats[3];
        }
        else
        { // enemy default stats
            int[] init = { 5, 2, 2, 5 };
            stats = init;
            healthCap = stats[3];
        }
    }


    /**
     * Used only by player to fight enemies (1 turn each)
     * Use a cloned arraylist (enemies) to initiate a while loop until
     * either all enemies are dead or player is dead
     *
     * @param other
     *            list of enemies(or enemy) to fight
     * @param choice (0 = potion, 1 = attack, 2 = dodge, 3 = block)
     * choosing the right counter negates dmg taken
     * @return 0 if no one died, 1 if enemy died, -1 if player died
     */
    public int combatEnemy(ArrayList<Entity> other, int choice)
    {
        if(choice > 2 || choice < 0)
        {
            return 0;
        }
        waitingRoom = new ArrayList<Entity>();
        order       = new PriorityQueue<Entity>(5, turn);
        for (Entity enemy : other)
        {
            order.offer(enemy);
            //System.out.println(enemy.getName());
        }
        order.offer(this);
        if (choice == 0)
        {
            System.out.println("pre heal: " + stats[3]);
            this.heal();
            System.out.println("post heal: " + stats[3]);
        }
        while (!order.isEmpty())
        {
            int dmg = 0;
            Entity first = order.poll();
            if (first instanceof Player)
            {
                if (choice == 1 && !order.isEmpty())
                {
                    Entity target = order.peek();   // peek target
                    dmg = target.stats()[1] - this.stats()[0];//def - att
                    if (dmg < 0)
                    {
                        //System.out.println(target.stats[3] + dmg);
                        target.addStat(3, dmg);
                        if (target.isDead())
                        {
                            order.remove(target);// remove from queue if dead
                            return 1;
                        }
                    }
                }
                else if (order.isEmpty() && waitingRoom.isEmpty())
                {
                    //System.out.println("welp");
                    return 1;
                }
                else if (!waitingRoom.isEmpty())
                {
                    for (Iterator<Entity> enemies = other.iterator(); enemies.hasNext();) // totally intended, too lazy to make target selection
                    {
                        Entity e = enemies.next();
                        dmg = e.stats()[1] - this.stats()[0]; //def - att
                        if (dmg < 0)
                        {
                            //System.out.println("dmg taken: " + dmg);
                            if (e instanceof Enemy)
                                e.addStat(3, dmg);
                            //System.out.println("hp: " + e.stats()[3]);
                            if (e.isDead())
                            {
                                order.remove(e);
                                return 1;
                            }
                        }
                    }
                }
            }
            else
            {

                Random type = new Random();
                int att = type.nextInt(3); // 0 = nothing, 1 = single target, 2
                                           // = aoe
                if (att == 2 && choice != 3)
                {
                    dmg = 0;
                    System.out.println(stats[3] + " hp check 2: " + maxHP());
                    dmg = 2 * first.stats()[0] - this.stats()[1]; // att - def
                    System.out.println(stats[3] + " hp check 5: " + maxHP());
                    if (dmg > 0)
                    {
                        //System.out.println(dmg + "aoe");
                        System.out.println(stats[3] + " hp check 1: " + maxHP());
                        this.addStat(3, -dmg);
                        System.out.println("net HP: " + (-dmg));
                    }
                    if (this.isDead())
                    {
                        return -1;
                    }
                }
                else if (att == 1 && choice != 2)
                {
                    dmg = 0;
                    System.out.println(stats[3] + " hp check 2: " + maxHP());
                    dmg = 2 * first.stats()[0] - this.stats()[2];// att - spd
                    System.out.println(stats[3] + " hp check 5: " + maxHP());
                    if (dmg > 0 )
                    {
                        System.out.println(stats[3] + " hp check 1: " + maxHP());
                        this.addStat(3, -dmg);
                        System.out.println("net HP: " + (-dmg));
                        if (this.isDead())
                        {
                            //System.out.println("died2 from " + dmg + " my hp after dmg: " + this.stats()[3]);
                            return -1;
                        }
                    }
                }
                else
                {
                    waitingRoom.add(first);

                }
            }

        }
        System.out.println(stats[3] + " hp check before return: " + maxHP());
        return 0;

    }

    /**
     * clears waitingRoom Queue to prevent bugs
     */
    public void clearWaitingRoom()
    {
        for(Iterator<Entity> enemies = waitingRoom.iterator(); enemies.hasNext();)
        {
            waitingRoom.remove(enemies.next());
        }
    }

    /**
     * changes name and sprite (instead of making new enemies)
     *
     * @param n
     *            new name
     * @param img
     *           new sprite
     */
    public void change(String n , String img)
    {
        this.name = n;
        this.sprite = img;
    }


    /**
     * increments a stat by an amt (used for combat, does not increment maxhp)
     *
     * @param stat
     *            att/def/spd/hp
     * @param amt
     *            an int amt
     */
    public void addStat(int stat, int amt)
    {
        if (stat == 3 && stats[3] + amt > healthCap)
        {
            stats[3] = healthCap;
        }
        else
        {
            stats[stat] += amt;
            System.out.println(stats[3] + " hp check 4: " + maxHP());
        }

    }

    /**
     * adds +1 to each stat
     */
    public void addStat()
    {
        for (int i = 0; i < stats.length; i++)
        {
            stats[i] += 1;
        }
        healthCap += 1;
    }


    /**
     * returns entity current stats
     *
     * @return (att, def, spd, hp)
     */
    public int[] stats()
    {
        return stats;
    }

    /**
     * method for testing
     * @return stats in order
     */
    public String getAllStats()
    {
        String str = "";
        for(int i = 0; i < 4; i++) {
            str += stats()[i] + " ";
        }
        return str;
    }

    /**
     * checks if entity is dead
     *
     * @return true if dead, false otherwise
     */
    public boolean isDead()
    {
        if (stats[3] <= 0)
        {
            //System.out.println("myHP | Dead : " + stats[3]);
            return true;
        }
        return false;
    }


    /**
     * heals entity, player's potions or maybe enemy(bug fix purposes)
     */
    public void heal()
    {
        if (stats[3] <= healthCap)
        {
            stats[3] = healthCap;
        }
    }

    /**
     * return max hp
     *
     * @return max hp
     */
    public int maxHP()
    {
        return healthCap;
    }

    /**
     * used by player when equipped with items
     * @param i new maxHP accounting for items
     */
    public void changeMaxHP(int i)
    {
        healthCap = i;
    }
    /**
     * return entity name for UI purposes
     *
     * @return String name
     */
    public String getName()
    {
        return name;
    }

    /**
     * return sprite for display during combat
     * @return sprite field
     */
    public String getSprite()
    {
        return sprite;
    }

}
