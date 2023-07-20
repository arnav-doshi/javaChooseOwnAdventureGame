
import java.util.*;


 // an entity class with equipment and potions, made for players

public class Player
    extends Entity
{
    private ArrayList<Loot> equipped;

    /**
     * Create a new Player object.
     *
     * @param name
     *        char name
     * @param img sprite
     */
    public Player(String name, String img)
    {
        super(name, img);
        equipped = new ArrayList<Loot>();
        equipped.add(0, new weapon());
        equipped.add(1, new helmet());
        equipped.add(2, new breastplate());
        equipped.add(3, new greaves());
    }


    /**
     * {@inheritDoc} take a potion to restore quarter max hp
     */
    public void heal()
    {
        if(super.stats()[3] == super.maxHP())
        {
            return;
        }
        int halfHP = super.maxHP() / 2;
        //System.out.println("hp to be healed : " + halfHP);
        int currentHP = super.stats()[3];
        //System.out.println("current HP: " + currentHP);
        //System.out.println("max HP: " + super.maxHP());
        if (currentHP + halfHP <= super.maxHP())
        {
            super.addStat(3, halfHP);
            //System.out.println("healed for: " + (halfHP));
            //System.out.println();
        }
        else
        {
            super.addStat(3, super.maxHP() - currentHP);
            //System.out.println("healed for1: " + (super.maxHP() - currentHP));
            //System.out.println();
        }
    }


    /**
     * {@inheritDoc} returns base stats + equipment stats
     */
    public int[] stats()
    {
        int[] effStats = new int[4];
        for (int i = 0; i < 4; i++)
        {
            effStats[i] = super.stats()[i];
        }

        for (Loot z : equipped)
        {
            for (int i = 0 ; i < 4; i++)
            {
                effStats[i] += z.allStats()[i];
            }
        }
        if (super.maxHP() < effStats[3])
        {
            super.changeMaxHP(effStats[3]);
        }
        return effStats;
    }



    /**
     * compares loot dropped to current loot
     * @param other loot dropped from enemy
     * @return String result of stat comparison
     */
    public String compareLoot(Loot other)
    {
        if (other instanceof weapon)
        {
            return equipped.get(0).compareTo(other);
        }
        else if (other instanceof helmet)
        {
            return equipped.get(1).compareTo(other);
        }
        else if (other instanceof breastplate)
        {
            return equipped.get(2).compareTo(other);
        }
        else
        {
            return equipped.get(3).compareTo(other);
        }
    }
    /**
     * replace currently equipped item
     *
     * @param item new item to replace
     */
    public void equipItem(Loot item)
    {
        if (item instanceof weapon)
        {
            equipped.set(0, item);
        }
        else if (item instanceof helmet)
        {
            equipped.set(1, item);
        }
        else if (item instanceof breastplate)
        {
            equipped.set(2, item);
        }
        else
        {
            equipped.set(3, item);
        }
    }

}
