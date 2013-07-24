package com.datalink.cellgames.xo;

/**
 * User: datalink
 * Date: 24.07.13
 * Time: 15:28
 */
public abstract class AbstractPlayerXO implements IPlayerXO {

    private char figure;

    public AbstractPlayerXO(char c)
    {
        figure = c;
    }

    public String Name()
    {
        return String.valueOf(figure);
    }

    public char Figure()
    {
        return figure;
    }
}
