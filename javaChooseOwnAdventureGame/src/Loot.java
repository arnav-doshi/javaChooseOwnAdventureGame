import java.util.Random;

public class Loot
{
    private int[] stats; // att, def, spd, hp in that order
    // an image sprite if possible

    /**
     * creates a loot obj (no args just in case)
     */
    public Loot()
    {
        stats = new int[4];
        int[] init = { 1, 1, 1, 1 };
        stats = init;

    }


    /**
     * Create a new Loot object.
     *
     * @param scalar
     *            a coefficient to help gear scale into late game
     */
    public Loot(int scalar)
    {
        stats = new int[4];
        Random roll = new Random();
        boolean hasStats = false;
        for (int i = 0; i < stats.length; i++)
        {
            int equip = roll.nextInt(100);
            if (equip % 4 == 0)
            {
                stats[i] = (int)(Math.random() * scalar);
                hasStats = true;
            }
            else
            {
                stats[i] = 1;
            }
        }
        if (!hasStats)
        {
            stats[3] = (int)(Math.random() * scalar);// at least you get hp
        }
    }

    /**
     * compares loot obtained with current loot
     * @param other new loot
     * @return stat difference between the two
     */
    public String compareTo(Loot other)
    {
        String statdiff = "att: " + (stats[0] - other.allStats()[0])
            + "def: " + (stats[1] - other.allStats()[1])
            + "spd: " + (stats[2] - other.allStats()[2])
            + "hp: " + (stats[3] - other.allStats()[3]);
        return statdiff;
    }

    /**
     * returns int[] stats for processing
     *
     * @return stats
     */
    public int[] allStats()
    {
        return stats;
    }

}
