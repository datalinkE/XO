/**
 * Created with IntelliJ IDEA.
 * User: Spectre
 * Date: 11.07.13
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class Cell {
    public final static char NOT_SET = ' ';
    private int x, y;
    private char figure  = NOT_SET;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int GetX()
    {
        return x;
    }

    public int GetY()
    {
        return y;
    }

    public void SetFigure(char player)
    {
         figure = player;
    }

    public char GetFigure()
    {
        return figure;
    }

    public boolean IsSet(char player)
    {
         return figure == player;
    }
}
