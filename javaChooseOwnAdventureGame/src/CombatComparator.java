public class CombatComparator
    implements java.util.Comparator<Entity>
{
    // ~ Fields ................................................................

    /**
     * creates a comparator by spd
     */
    public CombatComparator()
    {
    }


    public int compare(Entity obj1, Entity obj2)
    {
        if (obj1.stats()[2] > obj2.stats()[2])
        {
            return 1;
        }
        else if (obj1.stats()[2] < obj2.stats()[2])
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}
