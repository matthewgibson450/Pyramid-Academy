public class Land
{
    private boolean containsHuman;
    private boolean containsGoblin;

    public Land()
    {
        containsHuman = false;
        containsGoblin = false;
    }

    public Land(boolean containsHumanIn, boolean containsGoblinIn)
    {
        containsHuman = containsHumanIn;
        containsGoblin = containsGoblinIn;
    }

    public boolean getContainsHuman()
    {
        return containsHuman;
    }

    public boolean getContainsGoblin()
    {
        return containsGoblin;
    }

    public void toggleContainsHuman()
    {
        containsHuman = !containsHuman;
    }

    public void toggleContainsGoblin()
    {
        containsGoblin = !containsGoblin;
    }

    public boolean containsBoth()
    {
        return containsGoblin && containsHuman;
    }

    public String toString()
    {
        if(containsGoblin && containsHuman)
        {
            return "!";
        }
        else if(containsHuman)
        {
            return "H";
        }
        else if(containsGoblin)
        {
            return "G";
        }
        else
        {
            return " ";
        }
    }
}
