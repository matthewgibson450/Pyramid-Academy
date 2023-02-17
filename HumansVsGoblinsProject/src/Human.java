public class Human
{
    private int xLocation;
    private int yLocation;
    private boolean isAlive;

    public Human()
    {
       xLocation = (int)(Math.random() * 10);
       yLocation = (int)(Math.random() * 10);
       isAlive = true;
    }

    public Human(int xLocationIn, int yLocationIn)
    {
        xLocation = xLocationIn;
        yLocation = yLocationIn;
        isAlive = true;
    }

    public int getXLocation()
    {
        return xLocation;
    }

    public int getYLocation()
    {
        return yLocation;
    }

    public void setXLocation(int xLocationIn)
    {
        xLocation = xLocationIn;
    }

    public void setYLocation(int yLocationIn)
    {
        yLocation = yLocationIn;
    }

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public void toggleIsAlive()
    {
        isAlive = !isAlive;
    }

    public void move(String direction)
    {
        if(yLocation < 9 && (direction.equals("s") || direction.equals("south")))
        {
            yLocation++;
        }
        else if(yLocation > 0 && (direction.equals("n") || direction.equals("north")))
        {
            yLocation--;
        }
        else if(xLocation < 9 && (direction.equals("e") || direction.equals("east")))
        {
            xLocation++;
        }
        else if(xLocation > 0 && (direction.equals("w") || direction.equals("west")))
        {
            xLocation--;
        }
    }

    public String toString()
    {
        String returnString = "Human located at (" + xLocation + ", " + yLocation + ") is ";
        if(!isAlive)
        {
            returnString += "not ";
        }
        return returnString + "alive.";
    }
}
