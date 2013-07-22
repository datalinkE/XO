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

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setFigure(char player)
    {
         figure = player;
    }

    public char getFigure()
    {
        return figure;
    }

    public boolean isSet(char player)
    {
         return figure == player;
    }

    public void draw()
    {
        System.out.print("[");
        System.out.print(figure);
        System.out.print("]");
    }
}
